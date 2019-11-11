package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.restaurant;

import com.bignerdranch.testphilosophyjava.homecontrol.enumerations.Food;

public class Plate {
    private final Order order;
    private final Food food;
    public Plate(Order ord, Food f){
        order= ord;
        food = f;
    }
    public Order getOrder(){return order;}
    public Food getFood(){return food;}
    public String toString(){return food.toString();}
}
