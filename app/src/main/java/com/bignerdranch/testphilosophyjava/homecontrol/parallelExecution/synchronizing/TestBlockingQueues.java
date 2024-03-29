package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.LiftOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class TestBlockingQueues {
    static void getkey(){
        try {
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        }catch (java.io.IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message){
        print(message);
        getkey();
    }
    static void
    test(String msg, BlockingQueue<LiftOff> queue){
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i <5 ; i++)
            runner.add(new LiftOff(5));
        getkey("Press 'Enter' ("+msg+")");
        t.interrupt();
        print("Finished "+msg+" test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue",
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue",
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",
                new SynchronousQueue<LiftOff>());
    }
}
