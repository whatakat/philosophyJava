package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution;

import java.util.concurrent.DelayQueue;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q){
        this.q = q;
    }
    public void run(){
        try {
            while (!Thread.interrupted())
                q.take().run();
        }catch (InterruptedException e){

        }
        print("Finished DelayTaskConsumer");
    }
}
