package com.bignerdranch.testphilosophyjava.homecontrol.test3;

public class SimpleHolder {
    private Object obj;
    public void set(Object obj){this.obj = obj;}
    public Object get(){return obj;}

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("item");
        String s = (String)holder.get();
        System.out.println(s);
    }
}
