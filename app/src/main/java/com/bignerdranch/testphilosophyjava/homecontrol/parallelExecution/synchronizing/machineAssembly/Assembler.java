package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;
    public Assembler(CarQueue cq, CarQueue fq, RobotPool rp){
        chassisQueue=cq;
        finishingQueue = fq;
        robotPool = rp;
    }
    public Car car(){return car;}
    public CyclicBarrier barrier(){return  barrier;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await();
                finishingQueue.put(car);
            }
        }catch (InterruptedException e){
            print("Exiting Assembler via interrupt");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        print("Assembler off");
    }
}
