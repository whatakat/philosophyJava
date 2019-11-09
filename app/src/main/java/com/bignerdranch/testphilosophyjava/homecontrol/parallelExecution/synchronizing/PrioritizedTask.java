package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;
import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.printnb;

public  class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random rand = new Random(47);
    private static int counter = 0;
    private static int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence =
            new ArrayList<PrioritizedTask>();
    public PrioritizedTask(int priority){
        this.priority = priority;
        sequence.add(this);
    }
    public int compareTo(PrioritizedTask arg){
        return priority<arg.priority ? 1 :
                (priority>arg.priority ? -1 : 0);
    }
    public void run(){
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        }catch (InterruptedException e){

        }
        print(this);
    }
    public String toString(){
        return String.format("[%1$-3d]",priority)+
                " Task "+id;
    }
    public String summary(){
        return "("+id+":"+priority+")";
    }
    public  static class EndSentinel extends PrioritizedTask{
        private ExecutorService exec;
        public EndSentinel(ExecutorService e){
            super(-1);
            exec = e;
        }
        public void run(){
            int count = 0;
            for (PrioritizedTask pt: sequence){
                printnb(pt.summary());
                if (++count%5==0)
                    print();
            }
            print();
            print(this+" Calling shutdownNow()");
            exec.shutdownNow();
        }
    }

}
