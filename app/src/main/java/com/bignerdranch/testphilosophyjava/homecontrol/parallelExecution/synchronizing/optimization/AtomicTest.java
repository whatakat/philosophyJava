package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class AtomicTest extends Accumulator {
    {id = "Atomic";}
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);
    public void accumulate(){
        int i = index.getAndIncrement();
try {
    value.getAndAdd(preLoaded[i]);
}catch (ArrayIndexOutOfBoundsException e){
    print("Exception Atomic " +e);
}
        if (++i>=SIZE)
            index.set(0);
    }
    public long read(){return value.get();}
}
