package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Lifter {
    //making the motor
    public static WPI_VictorSPX lifterScotty = new WPI_VictorSPX(RobotMap.liftMeUpScottyCAN);

    public static void LifterSetup() {
        //sets up the victor
        lifterScotty.configFactoryDefault();
        lifterScotty.setInverted(false);
    }
    
    public static void LifterMover() {
        //the part where it makes scotty moves
        lifterScotty.set(Robot.oi.getFlightJoyY());
    }
}