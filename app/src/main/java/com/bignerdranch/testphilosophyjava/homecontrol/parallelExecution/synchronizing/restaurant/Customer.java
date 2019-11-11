package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.restaurant;

import com.bignerdranch.testphilosophyjava.homecontrol.enumerations.Course;
import com.bignerdranch.testphilosophyjava.homecontrol.enumerations.Food;

import java.util.concurrent.SynchronousQueue;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private SynchronousQueue<Plate> placeSetting =
            new SynchronousQueue<Plate>();
    public Customer(WaitPerson w){waitPerson=w;}
    public void
    deliver(Plate p)throws InterruptedException{
        placeSetting.put(p);
    }
    public void run(){
        for (Course course: Course.values()){
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this, food);
                print(this + "eating "+placeSetting.take());
            }catch (InterruptedException e){
                print(this+"waiting for "+
                        course+" interrupted");
                break;
            }
        }
        print(this+"finished meal, leaving");
    }
    public String toString(){
        return "Customer "+id+" ";
    }
}
