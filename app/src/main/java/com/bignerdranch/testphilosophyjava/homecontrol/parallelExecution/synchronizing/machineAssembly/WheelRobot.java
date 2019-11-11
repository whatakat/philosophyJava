package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool){super(pool);}
    protected void performService(){
        print(this+" installing Wheels");
        assembler.car().addWheels();
    }
}
