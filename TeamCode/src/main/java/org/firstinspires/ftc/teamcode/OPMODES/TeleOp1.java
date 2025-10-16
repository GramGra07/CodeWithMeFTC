package org.firstinspires.ftc.teamcode.OPMODES;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.config.HardwareConfig;

@TeleOp(name = "TeleOp1")
public class TeleOp1 extends LinearOpMode {
    HardwareConfig robot = null;
    @Override
    public void runOpMode() {
        robot = new HardwareConfig(this, hardwareMap,false);

        waitForStart();
        while (opModeIsActive()) {
            robot.doBulk();
        }
    }
}
