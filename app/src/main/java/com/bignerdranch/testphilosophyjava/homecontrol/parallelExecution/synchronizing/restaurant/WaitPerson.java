package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.restaurant;

import com.bignerdranch.testphilosophyjava.homecontrol.enumerations.Food;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

 public class WaitPerson implements Runnable {
    private static int counter =0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders=
            new LinkedBlockingQueue<Plate>();
    public WaitPerson(Restaurant res){restaurant=res;}
    public void placeOrder(Customer cust, Food food){
        try {
            restaurant.orders.put(new Order(cust,this , food));
        }catch (InterruptedException e){
            print(this+" placeOrder interrupted");
        }
    }
    public void run(){
        try {
            while (!Thread.interrupted()){
                Plate plate = filledOrders.take();
                print(this+"received "+plate+
                        " delivering to "+
                        plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        }catch (InterruptedException e){
            print(this+" interrupted");
        }
        print(this+" off duty");
    }
    public String toString(){
        return "WaitPerson "+id+" ";
    }
}
