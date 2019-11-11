package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.concurrent.ArrayBlockingQueue;

public class CustomerLine extends ArrayBlockingQueue<CustomerS> {
    public CustomerLine(int maxLineSize){
        super(maxLineSize);
    }
    public String toString(){
        if (this.size()==0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (CustomerS customerS : this)
            result.append(customerS);
        return result.toString();
    }
}
