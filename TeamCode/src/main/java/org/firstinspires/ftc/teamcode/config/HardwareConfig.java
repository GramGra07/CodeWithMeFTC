package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;

public class HardwareConfig {
    LinearOpMode opMode = null;
    Telemetry telemetry = null;
    DcMotor motorTest = null;
    DcMotor fl = null;
    DcMotor fr = null;
    DcMotor bl = null;
    DcMotor br = null;

    public ArmSubsystem armsub = null;
    public ClawSubsystem clawsub = null;
    ElapsedTime runtime = new ElapsedTime();

    public HardwareConfig(LinearOpMode opMode, HardwareMap hw, boolean auto){
        initRobot(hw, opMode, auto);
    }
    private void initRobot(HardwareMap hw, LinearOpMode om,boolean auto){
        opMode = om;
        telemetry = om.telemetry;
        armsub = new ArmSubsystem(hw,auto);
        clawsub = new ClawSubsystem(hw);

        motorTest = hw.dcMotor.get("motorTest");
        motorTest.setDirection(DcMotor.Direction.FORWARD);
        motorTest.setPower(0);
        fl = hw.dcMotor.get("frontLeft");
        fr = hw.dcMotor.get("frontRight");
        bl = hw.dcMotor.get("backLeft");
        br = hw.dcMotor.get("backRight");
        fl.setDirection(DcMotor.Direction.FORWARD);
        fr.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.FORWARD);
        br.setDirection(DcMotor.Direction.REVERSE);
        runtime.reset();
    }
    public void buildTelemetry(){
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motor Test", motorTest.getPower());
        telemetry.addData("Gamepad down", opMode.gamepad1.dpad_down);
        armsub.telemetry(telemetry);
        clawsub.telemetry(telemetry);
        telemetry.update();
    }
    public void doBulk(){
        double y = -opMode.gamepad1.left_stick_y;
        double x = opMode.gamepad1.left_stick_x * 1.1;
        double rx = opMode.gamepad1.right_stick_x;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        motorTest.setPower(opMode.gamepad1.right_trigger);
        // control any subsystems

        if (opMode.gamepad1.a){
            armsub.m1Power = 1.0;
        }else{
            armsub.m1Power = 0.0;
        }

        if (opMode.gamepad1.b){
            clawsub.setClawOpen();
        }else if (opMode.gamepad1.x){
            clawsub.setClawClose();
        }else{
            clawsub.setClawIdle();
        }


        fl.setPower(frontLeftPower);
        bl.setPower(backLeftPower);
        fr.setPower(frontRightPower);
        br.setPower(backRightPower);
        armsub.update();
        clawsub.update();
        buildTelemetry();
    }
}
