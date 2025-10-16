package org.firstinspires.ftc.teamcode.OPMODES;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.config.AutoConfig;

@Autonomous(name = "Auto1")
public class Auto1 extends LinearOpMode {
    AutoConfig robot = null;
    @Override
    public void runOpMode() {
        robot = new AutoConfig(this, hardwareMap);
        waitForStart();
        if (opModeIsActive()) {// OpMode loop
            robot.moveForward(0.5);
            robot.moveForward(1);
//            robot.turn();
        }
    }
}
