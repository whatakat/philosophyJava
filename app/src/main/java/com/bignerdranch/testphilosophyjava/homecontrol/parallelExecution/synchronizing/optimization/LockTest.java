package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Accumulator {
    {id = "Lock";}
    private Lock lock = new ReentrantLock();
    public void accumulate(){
        lock.lock();
        try {
            value+=preLoaded[index++];
            if (index>=SIZE) index = 0;
        }finally {
            lock.unlock();
        }
    }
    public long read(){
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();
        }
    }
}
