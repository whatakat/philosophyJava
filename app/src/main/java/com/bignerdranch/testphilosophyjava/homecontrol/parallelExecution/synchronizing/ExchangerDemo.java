package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import com.bignerdranch.testphilosophyjava.homecontrol.test3.BasicGenerator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;

    public static void main(String[] args) throws Exception {
        if (args.length>0)
            size = new Integer(args[0]);
        if (args.length>1)
            delay = new Integer(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<Fat>(),
                consumerList = new CopyOnWriteArrayList<Fat>();
        exec.execute(new ExchengerProducer<Fat>(xc, BasicGenerator.create(Fat.class),producerList));
        exec.execute(
                new ExchangerConsumer<Fat>(xc,consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();

    }
}
