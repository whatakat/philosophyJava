package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;
import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.printnb;

public class WaxOn implements Runnable {
    private CarS car;
    public WaxOn(CarS c){car =c;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                printnb("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }

        }catch (InterruptedException e){
            print("Exiting via interrupt");
        }
        print("Ending Wax On task");
    }
}
