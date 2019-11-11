package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.machineAssembly;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;

public class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool pool){super(pool);}
    protected void performService(){
        print(this+" installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}
