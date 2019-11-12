package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class BaseLine extends Accumulator {
    {id = "BaseLine";}
    public void accumulate(){
        try {
            value=preLoaded[index++];
        }catch (ArrayIndexOutOfBoundsException e){
            print("Exception BaseLine "+e);
        }
        if (index>=SIZE) index = 0;
    }
    public long read(){return value;}
}
