package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class Sensors {

    public static DigitalInput intakeStopSwitch = new DigitalInput(RobotMap.intakeStopSwitchDIO);

    public static void SensorSetup() {
    }

    public static boolean getintakeStop() {
        return intakeStopSwitch.get();
    }
}