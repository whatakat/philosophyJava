package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;
    public ChassisBuilder(CarQueue cq){carQueue = cq;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                print("ChassisBuilder created "+ c);
                carQueue.put(c);
            }
        }catch (InterruptedException e){
            print("Interrupted: ChassisBuilder");
        }
        print("ChassisBuilder off");
    }
}
