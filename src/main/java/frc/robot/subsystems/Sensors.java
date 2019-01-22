package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.RobotMap;

public class Sensors {
    //ultrasonic
    public static Ultrasonic ultraBoi = new Ultrasonic(RobotMap.ultrasonicInputDIO, RobotMap.ultrasonicOutputDIO);

    //if a sensor needs to be set up do it in here
    public static  void SensorSetup() {
        ultraBoi.setAutomaticMode(true);
    }

    public static double getUltraBoiDistance() {
        return Math.round(ultraBoi.getRangeInches());
    }
}