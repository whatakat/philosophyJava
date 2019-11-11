package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;
import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.printnb;

public class WaxOff implements Runnable {
    private CarS car;
    public WaxOff(CarS c){car = c;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                car.waitForWaxing();
                printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}
