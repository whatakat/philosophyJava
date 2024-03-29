package com.bignerdranch.testphilosophyjava.homecontrol.enumerations;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class TrafficLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            case RED: color= Signal.GREEN;
            break;
            case GREEN: color = Signal.YELLOW;
            break;
            case YELLOW: color = Signal.RED;
            break;
        }
    }
    public String toString(){
        return "The traffic light is "+ color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i <7 ; i++) {
            print(t);
            t.change();

        }
    }
}
