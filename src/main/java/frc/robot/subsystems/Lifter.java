package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Lifter {
    //making the motor
    public static WPI_VictorSPX lifterScotty = new WPI_VictorSPX(RobotMap.liftMeUpScottyCAN);
    public static WPI_TalonSRX hatchLatch = new WPI_TalonSRX(RobotMap.hatchLatchCAN);

    //sets up the motors
    public static void LifterSetup() {
        //Reset the victors to the default settings
        lifterScotty.configFactoryDefault();
        hatchLatch.configFactoryDefault();

        //Invert the motors incase it is backwards
        lifterScotty.setInverted(false);
        hatchLatch.setInverted(true);
    }
    
    //Moves the lifter when you move the flightstick
    public static void LifterMover() {
        lifterScotty.set(Robot.oi.getFlightJoyY());
    }

    //Moves the hatch grabber
    public static void HatchLatchMove() {
        if (Robot.oi.flight.getRawButton(RobotMap.hatchLatchFlightOpenButton)) {
            hatchLatch.set(1);
        }
        else if (Robot.oi.flight.getRawButton(RobotMap.hatchLatchFlightCLoseButton)) {
            hatchLatch.set(-1);
        }
        else {
            hatchLatch.set(0);
        }
    }
}