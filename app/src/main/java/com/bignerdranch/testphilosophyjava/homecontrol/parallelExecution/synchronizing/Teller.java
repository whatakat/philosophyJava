package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    private final int id = counter++;
    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    public Teller(CustomerLine cq){customers = cq;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                CustomerS customerS = customers.take();
                TimeUnit.MILLISECONDS.sleep(
                        customerS.getServiseTime());
                synchronized (this){
                    customerServed++;
                    while (!servingCustomerLine)
                        wait();
                }
            }
        }catch (InterruptedException e){
            print(this+"interrupted");
        }
        print(this+"terminating");
    }
    public synchronized void doSomethingElse(){
        customerServed = 0;
        servingCustomerLine = false;
    }
    public synchronized void serveCustomerLine(){
        assert !servingCustomerLine:"already serving: "+this;
        servingCustomerLine = true;
        notifyAll();
    }
    public String toString(){return "Teller "+id+" ";}
    public String shortString(){return "T"+id;}
    public synchronized int compareTo(Teller other){
        return customerServed<other.customerServed?-1:
                (customerServed==other.customerServed ? 0 : 1);
    }
}
