package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;
import org.gentrifiedApps.gentrifiedAppsUtil.classes.Scribe;
import org.gentrifiedApps.gentrifiedAppsUtil.classes.drive.DrivePowerCoefficients;
import org.gentrifiedApps.gentrifiedAppsUtil.drive.MecanumDriver;
import org.gentrifiedApps.gentrifiedAppsUtil.hardware.motor.PIDMotor;
import org.gentrifiedApps.gentrifiedAppsUtil.hardware.servo.ServoPlus;
import org.gentrifiedApps.gentrifiedAppsUtil.heatseeker.Driver;
import org.gentrifiedApps.gentrifiedAppsUtil.looptime.LoopTimeController;

public class HardwareConfig {
    LinearOpMode opMode = null;
    Telemetry telemetry = null;
    DcMotor motorTest = null;

    Driver drive = null;
    LoopTimeController ltc = new LoopTimeController();
    ServoPlus sPlus = null;
    // package pid controller and motor
    PIDMotor pMotor = null;

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
        runtime.reset();

        sPlus = new ServoPlus(hw, "sPlus");

        pMotor = new PIDMotor(hw, "pMotor");
        pMotor.setPIDF(0.0,0.0,0.0,0.0);
        pMotor.setPIDPower();


        drive = new Driver(opMode,"frontLeft", "frontRight", "backLeft", "backRight", DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE);
        ltc.reset();
        Scribe.getInstance().startLogger(opMode);
    }
    public void buildTelemetry(){
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motor Test", motorTest.getPower());
        telemetry.addData("Gamepad down", opMode.gamepad1.dpad_down);
        armsub.telemetry(telemetry);
        clawsub.telemetry(telemetry);
        ltc.telemetry(telemetry);
        telemetry.update();
    }
    public void doBulk(){
        DrivePowerCoefficients powers = MecanumDriver.driveMecanum(opMode.gamepad1.left_stick_x,-opMode.gamepad1.left_stick_y,opMode.gamepad1.right_stick_x);


        motorTest.setPower(opMode.gamepad1.right_trigger);
        // control any subsystems

        if (opMode.gamepad1.a){
            armsub.m1Power = 1.0;
            Scribe.getInstance().logData("Arm powered to 1.0");
        }else{
            armsub.m1Power = 0.0;
            sPlus.setPosition(90);
        }

        if (opMode.gamepad1.b){
            clawsub.setClawOpen();
        }else if (opMode.gamepad1.x){
            clawsub.setClawClose();
        }else{
            clawsub.setClawIdle();
        }
        ltc.update();


        drive.setWheelPower(powers);
        armsub.update();
        clawsub.update();
        buildTelemetry();
    }
}
