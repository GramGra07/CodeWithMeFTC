package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawSubsystem {
    // state machines
    private Servo clawServo = null;

    public ClawSubsystem(HardwareMap hwMap) {
        clawServo = hwMap.get(Servo.class,"clawservo");
        //reverse

    }
    public enum ClawState{OPEN,CLOSE,IDLE}
    private ClawState clawState = ClawState.IDLE;
    public void setClawOpen(){
        clawState = ClawState.OPEN;
    }
    public void setClawClose(){
        clawState = ClawState.CLOSE;
    }
    public void setClawIdle(){
        clawState = ClawState.IDLE;
    }

    public void update(){
        switch (clawState){
            case OPEN:
                clawServo.setPosition(0.25);
                break;
            case CLOSE:
                clawServo.setPosition(0.75);
                break;
            case IDLE:
                break;
        }
    }

    public void telemetry(Telemetry telemetry){
        telemetry.addData("Claw State", clawState);
    }

}
