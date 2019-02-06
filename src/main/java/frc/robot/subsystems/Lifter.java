package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Lifter {
    //making the motor
    public static WPI_VictorSPX lifterScotty = new WPI_VictorSPX(RobotMap.liftMeUpScottyCAN);

    //sets up the motors
    public static void LifterSetup() {
        //Reset the victors to the default settings
        lifterScotty.configFactoryDefault();

        //Invert the motors incase it is backwards
        lifterScotty.setInverted(false);
    }
    
    //Moves the lifter when you move the flightstick
    public static void LifterMover() {
        lifterScotty.set(Robot.oi.getFlightJoyY());
    }
}