package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

public class SynchronizingTest extends Incrementable {
    public synchronized void increment(){++counter;}
}
