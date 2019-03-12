package frc.robot.subsystems;

import frc.robot.Robot;

public class CameraSwitch {

    public static void TimeToSwitch() {
        if (Robot.oi.cameraSwitchButton.get() && !Robot.prevTrigger) {
            Robot.serverToSee.setSource(Robot.cargoCamera);
        }
        else if (!Robot.oi.cameraSwitchButton.get() && Robot.prevTrigger) {
            Robot.serverToSee.setSource(Robot.liftCamera);
        }
        Robot.prevTrigger = Robot.oi.cameraSwitchButton.get();
    }
}