package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

public class CustomerS {
    private final int serviceTime;
    public CustomerS(int tm){ serviceTime = tm;}
    public int getServiseTime(){return serviceTime;}
    public String toString(){
        return "["+serviceTime+"]";
    }
}
