package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.gentrifiedApps.gentrifiedAppsUtil.classes.Subsystem;

public class BaseSubsystem extends Subsystem {
    public BaseSubsystem(@NonNull HardwareMap hwMap, boolean auto) {
        super(hwMap, auto);
        init();
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void telemetry(@NonNull Telemetry telemetry) {

    }
}
