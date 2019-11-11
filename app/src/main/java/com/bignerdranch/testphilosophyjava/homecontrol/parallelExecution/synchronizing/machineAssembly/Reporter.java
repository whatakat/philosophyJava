package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class Reporter implements Runnable {
    private CarQueue carQueue;
    public Reporter(CarQueue cq){carQueue = cq;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                print(carQueue.take());
            }
        }catch (InterruptedException e){
            print("Exiting Reporter via interrupt");
        }
        print("Reporter off");
    }
}
