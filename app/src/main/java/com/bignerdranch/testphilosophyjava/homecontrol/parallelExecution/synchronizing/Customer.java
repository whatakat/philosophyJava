package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

public class Customer {
    private final int serviceTime;
    public Customer (int tm){ serviceTime = tm;}
    public int getServiseTime(){return serviceTime;}
    public String toString(){
        return "["+serviceTime+"]";
    }
}
