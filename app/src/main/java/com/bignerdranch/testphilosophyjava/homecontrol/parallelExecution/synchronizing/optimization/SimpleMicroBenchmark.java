package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

public class SimpleMicroBenchmark {
    static long test(Incrementable incr){
        long start = System.nanoTime();
        for (int i = 0; i < 10000000L; i++)
            incr.increment();
        return System.nanoTime()-start;
    }

    public static void main(String[] args) {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());
        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("Lock:         %1$10d\n", lockTime);
        System.out.printf("Lock/synchronized = %1$.3f",(double)lockTime/(double)synchTime);
    }
}
