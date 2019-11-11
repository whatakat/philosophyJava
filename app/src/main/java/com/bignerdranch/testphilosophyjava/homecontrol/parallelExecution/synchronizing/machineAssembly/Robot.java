package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import java.util.concurrent.BrokenBarrierException;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public abstract class Robot implements Runnable {
    private RobotPool pool;
    public Robot(RobotPool p){pool = p;}
    protected Assembler assembler;
    public Robot assignAssembler(Assembler assembler){
        this.assembler = assembler;
        return this;
    }
    private boolean engane = false;
    public synchronized void engane(){
        engane = true;
        notifyAll();
    }
    abstract protected void performService();
    public void run(){
        try {
            powerDown();
            while (!Thread.interrupted()){
                performService();
                assembler.barrier().await();
                powerDown();
            }
        }catch (InterruptedException e){
            print("Exiting "+ this+" via interrupt");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        print(this+" off");
    }
    private synchronized void powerDown() throws InterruptedException{
        engane = false;
        assembler = null;
        pool.release(this);
        while (engane==false)
            wait();
    }
    public String toString(){return getClass().getName();}
}
