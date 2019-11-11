package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import com.bignerdranch.testphilosophyjava.homecontrol.generator.Generator;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchengerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchenger;
    private List<T> holder;
    ExchengerProducer(Exchanger<List<T>> exchg,
                      Generator<T> gen, List<T> holder){
        exchenger = exchg;
        generator = gen;
        this.holder = holder;
    }
    public void run(){
        try {
            while (!Thread.interrupted()){
                for (int i = 0; i <ExchangerDemo.size; i++)
                    holder = exchenger.exchange(holder);
            }
        }catch (InterruptedException e){

        }
    }
}
