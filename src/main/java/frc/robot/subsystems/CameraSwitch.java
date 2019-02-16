package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class CameraSwitch {

    public static void TimeToSwitch() {
        if (Robot.oi.xbox.getRawButton(RobotMap.cameraSwitcherXboxButton) && !Robot.prevTrigger) {
            Robot.serverToSee.setSource(Robot.liftCamera);
        }
        else if (!Robot.oi.xbox.getRawButton(RobotMap.cameraSwitcherXboxButton) && Robot.prevTrigger) {
            Robot.serverToSee.setSource(Robot.cargoCamera);
        }
        Robot.prevTrigger = Robot.oi.xbox.getRawButton(RobotMap.cameraSwitcherXboxButton);
    }
}