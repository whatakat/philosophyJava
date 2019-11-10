package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class Fat {
    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;
    public Fat(){
        for (int i = 0; i < 1000; i++) {
            d +=(Math.PI + Math.E)/(double)i;

        }
    }
    public void operation(){print(this);}
    public String toString(){return "Fat id: "+id;}
}
