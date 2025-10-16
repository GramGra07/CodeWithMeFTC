package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class AutoConfig extends HardwareConfig {
    boolean tracking = false;
    int state = 0;
    double startTime = 0;
    double currentTime = 0;
    double elapsedTime = 0;

    public AutoConfig(LinearOpMode opMode, HardwareMap hw) {
        super(opMode, hw,true);
        initAuto();
    }
    void initAuto(){
        tracking = false;
        state = 0;
        startTime = 0;
        currentTime = 0;
        elapsedTime = 0;
    }
    public void moveForward(double power){
        super.motorTest.setPower(power);
    }
}
