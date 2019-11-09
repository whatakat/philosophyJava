package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;
import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.printnb;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence =
            new ArrayList<DelayedTask>();
    public DelayedTask(int delayInMilliseconds){
        delta = delayInMilliseconds;
        trigger = System.nanoTime()+
                NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }
    public long getDelay(TimeUnit unit){
        return unit.convert(
                trigger - System.nanoTime(), NANOSECONDS);
    }
    public int compareTo(Delayed arg){
        DelayedTask that = (DelayedTask)arg;
        if (trigger<that.trigger) return -1;
        if (trigger>that.trigger) return 1;
        return 0;
    }
    public void run(){printnb(this+" ");}
    public String toString(){
        return String.format("[%l$-4d]", delta)+
                " Task "+id;
    }
    public String summary(){
        return "("+id+":"+delta+")";
    }
    public static class EndSentinel extends DelayedTask{
        private ExecutorService exec;
        public EndSentinel(int delay, ExecutorService e){
            super(delay);
            exec = e;
        }
        public void run(){
            for (DelayedTask pt: sequence){
                printnb(pt.summary()+" ");
            }
            print();
            print(this +" Calling shutdownNow()");
            exec.shutdownNow();
        }
    }

}
