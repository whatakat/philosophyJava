package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import java.util.HashSet;
import java.util.Set;

public class RobotPool {
    private Set<Robot> pool = new HashSet<Robot>();
    public synchronized void add(Robot r){
        pool.add(r);
        notifyAll();
    }
    public synchronized void hire(Class<? extends Robot> robotType, Assembler d)
        throws InterruptedException{
        for (Robot r: pool)
            if (r.getClass().equals(robotType)){
                pool.remove(r);
                r.assignAssembler(d);
                r.engane();
                return;
            }
        wait();
            hire(robotType, d);
    }
    public synchronized void release(Robot r){add(r);}
}
