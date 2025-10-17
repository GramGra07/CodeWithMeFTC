package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmSubsystem {
    DcMotor m1 = null;
    boolean auto = false;
    public double m1Power = 0;
    public ArmSubsystem(HardwareMap hwMap, Boolean auto) {
        this.auto = auto;
        m1 = hwMap.get(DcMotor.class, "m1");
        // reverse if needed
        //init()

    }

    public void update(){
        power();
    }
    public void telemetry(Telemetry telemetry){
        telemetry.addData("Arm Power", m1.getPower());
    }

    private void power(){
        m1.setPower(m1Power);
    }

    // m1Power = this or whatever


}

