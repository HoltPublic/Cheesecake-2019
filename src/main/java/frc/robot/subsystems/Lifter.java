package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Lifter {
    //making the motor
    //public static WPI_VictorSPX lifterScotty = new WPI_VictorSPX(RobotMap.liftMeUpScottyCAN);
    public static WPI_TalonSRX hatchLatch = new WPI_TalonSRX(RobotMap.hatchLatchCAN);
    public static DigitalInput hatchStopTopLS = new DigitalInput(RobotMap.hatchStopTopDIO);
    public static DigitalInput hatchStopBottonLS = new DigitalInput(RobotMap.hatchStopBottomDIO);
    public static WPI_VictorSPX theLift = new WPI_VictorSPX(RobotMap.liftMeUpScottyCAN);

    //sets up the motors
    public static void LifterSetup() {
        //Reset the victors to the default settings
        //lifterScotty.configFactoryDefault();
        hatchLatch.configFactoryDefault();

        //Invert the motors incase it is backwards
        //lifterScotty.setInverted(false);
        hatchLatch.setInverted(false);
    }
    
    //Moves the lifter when you move the flightstick
    public static void LifterMover() {
     theLift.set(Robot.oi.getFlightJoyY());
    }

    //Moves the hatch grabber
    public static void HatchLatchMove() {
        if (Robot.oi.hatchOpenButton.get() && hatchStopBottonLS.get()) {
            hatchLatch.set(1);
        }
        else if (Robot.oi.hatchCloseButton.get() && hatchStopTopLS.get()) {
            hatchLatch.set(-1);
        }
        else {
            hatchLatch.set(0);
        }
    }
}