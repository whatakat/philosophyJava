package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.concurrent.PriorityBlockingQueue;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;
    public PrioritizedTaskConsumer(
            PriorityBlockingQueue<Runnable> q){
        this.q = q;
    }
    public void run(){
        try {
            while (!Thread.interrupted())
                q.take().run();
        }catch (InterruptedException e){

        }
        print("Finished PrioritizedTaskConsumer");
    }
}
