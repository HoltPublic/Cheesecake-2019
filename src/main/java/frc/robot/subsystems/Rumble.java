package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Rumble {
    
    //button for testing the rumble
    public static void rumbleRun() {
        if (Robot.oi.xbox.getRawButton(RobotMap.rumbleTestXboxButton)) {
            Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 1);
            Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 1);
        }
        else {
            Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 0);
            Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 0);
        }
    }
}