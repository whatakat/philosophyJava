package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingTest extends Incrementable {
    private Lock lock = new ReentrantLock();
    public void increment(){
        lock.lock();
        try {
            ++counter;
        }finally {
            lock.unlock();
        }
    }
}
