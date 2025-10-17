package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;

import org.firstinspires.ftc.robotcore.internal.opmode.OpModeMeta;

import org.gentrifiedApps.gentrifiedAppsUtil.config.ConfigMaker;
import org.gentrifiedApps.gentrifiedAppsUtil.config.ConfigCreator;

public final class ConfigRegistrar {

    static ConfigMaker config = new ConfigMaker("pinkbot")
            .addDevice("servo", ConfigMaker.ModuleType.CONTROL_HUB, ConfigMaker.DeviceType.Servo, 1)
.addMotor("m1", ConfigMaker.ModuleType.CONTROL_HUB, ConfigMaker.MotorType.RevRobotics40HDHexMotor, 2);

    static boolean isEnabled = true;
    private ConfigRegistrar() {
    }

    private static OpModeMeta metaForClass(Class<? extends OpMode> cls) {
        return new OpModeMeta.Builder()
                .setName(cls.getSimpleName())
                .setGroup("Config")
                .setFlavor(OpModeMeta.Flavor.TELEOP)
                .build();
    }

    @OpModeRegistrar
    public static void register(OpModeManager manager) {
        if (!isEnabled) return;
        manager.register(metaForClass(ConfigCreator.class), new ConfigCreator(config));
    }
}
    