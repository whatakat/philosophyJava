package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.List;
import java.util.concurrent.Exchanger;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
        exchanger = ex;
        this.holder = holder;
    }
    public void run(){
        try {
            while (!Thread.interrupted()){
                holder = exchanger.exchange(holder);
                for (T x: holder){
                    value = x;
                    holder.remove(x);
                }
            }
        }catch (InterruptedException e){

        }
        print("Final value: "+value);
    }
}
