package com.bignerdranch.testphilosophyjava.homecontrol.test3;

public class CountedObject {
    private static long counter=0;
    private final long id = counter++;
    public long id(){return id;}
    public String toString(){return "CountedObject "+id;}
}
