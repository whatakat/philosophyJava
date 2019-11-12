package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

public class SynchronizedTest extends Accumulator {
    {id = "synchronized";}
    public synchronized void accumulate(){
        value+=preLoaded[index++];
        if (index>=SIZE) index = 0;
    }
    public synchronized long read(){
        return value;
    }
}
