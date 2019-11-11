package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class EngineRobot extends Robot {
    public EngineRobot(RobotPool pool){super(pool);}
    protected void performService(){
        print(this+" installing engine");
        assembler.car().addEngine();
    }
}
