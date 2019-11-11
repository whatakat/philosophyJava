package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers =
            new PriorityQueue<Teller>();
    private Queue<Teller> tellersDoingOtherThings =
            new LinkedList<Teller>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);
    public TellerManager(ExecutorService e,
                         CustomerLine customers, int adjustmentPeriod){
        exec=e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }
    public void adjustTellerNumber(){
        if (customers.size()/workingTellers.size()>2){
            if (tellersDoingOtherThings.size()>0){
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        if (workingTellers.size()>1 &&
        customers.size()/workingTellers.size()<2)
            reassignOneTeller();
        if (customers.size()==0)
            while (workingTellers.size()>1)
                reassignOneTeller();
    }
    private void reassignOneTeller(){
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
        }
        public void run(){
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                print(customers+"{");
                for (Teller teller: workingTellers)
                    print(teller.shortString()+" ");
                print("}");
            }
        }catch (InterruptedException e){
            print(this+"interrupted");
        }
        print(this+"terminating");
    }
    public String toString(){return "TellerManager";}
}

