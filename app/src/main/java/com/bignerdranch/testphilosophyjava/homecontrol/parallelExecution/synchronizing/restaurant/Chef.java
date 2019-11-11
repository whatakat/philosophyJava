package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.restaurant;

import com.bignerdranch.testphilosophyjava.homecontrol.enumerations.Food;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class Chef implements Runnable {
    private static int counter=0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);
    public Chef(Restaurant rest){restaurant = rest;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        }catch (InterruptedException e){
            print(this+" interrupted");
        }
        print(this+" off duty");
    }
    public String toString(){return "Chef "+id+" ";}
}
