package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;
import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.printnb;

public class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool){
        this.pool = pool;
    }
    public void run(){
        try {
            T item = pool.checkOut();
            print(this+"checked out "+item);
            TimeUnit.SECONDS.sleep(1);
            print(this +"checking in "+item);
            pool.checkIn(item);
        }catch (InterruptedException e){

        }
    }
    public String toString(){
        return "CheckoutTask "+id+" ";
    }

}
