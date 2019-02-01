package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class Sensors {

    public static DigitalInput hallEffectTop = new DigitalInput(RobotMap.hallEffectTopDIO);
    public static DigitalInput hallEffectBottom = new DigitalInput(RobotMap.hallEffectBottomDIO);
    public static DigitalInput intakeStopSwitch = new DigitalInput(RobotMap.intakeStopSwitchDIO);
 
    public static void SensorSetup() {
    }

    public static boolean getHallEffectTopBoi() {
        return hallEffectTop.get(); 
    }

    public static boolean getHallEffectBottomBoi() {
        return hallEffectBottom.get(); 
    }

    public static boolean getintakeStop() {
        return intakeStopSwitch.get();
    }
}