package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

public class BaseLine extends Accumulator {
    {id = "BaseLine";}
    public void accumulate(){
        value+=preLoaded[index++];
        if (index>=SIZE) index = 0;
    }
    public long read(){return value;}
}
