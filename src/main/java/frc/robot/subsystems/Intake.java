package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Intake {
    //Making the Motors
    public static WPI_VictorSPX succBoiTop = new WPI_VictorSPX(RobotMap.succBoiTopCAN);
    public static WPI_VictorSPX succBoiBottom = new WPI_VictorSPX(RobotMap.succBoiBottomCAN);
    public static WPI_VictorSPX armMoverMotor = new WPI_VictorSPX(RobotMap.armMoverCAN);
    
    //sets up the motors
    public static void IntakeSetup() {
        //sets them to the default settings
        succBoiTop.configFactoryDefault();
        succBoiBottom.configFactoryDefault();
        armMoverMotor.configFactoryDefault();

        //Invert the motors incase they are backwards
        succBoiTop.setInverted(false);
        succBoiBottom.setInverted(false);
        armMoverMotor.setInverted(false);
    }

    //the class to spin the intake
    public static void BallIntake() {
        if (Robot.oi.flight.getRawButton(RobotMap.intakeInFlightButton)) {
            succBoiTop.set(1);
            succBoiBottom.set(1);
        }
        else if (Robot.oi.flight.getRawButton(RobotMap.intakeOutFlightButton)) {
            succBoiTop.set(-1);
            succBoiBottom.set(-1);
        }
        else {
            succBoiTop.set(0);
            succBoiBottom.set(0);
        }
    }

    //moves the arm that the intake in on
    public static void ArmMover() {
        if (Robot.oi.flight.getRawButton(RobotMap.armMoveUpFlightButton)) {
            armMoverMotor.set(1);
        } else if (Robot.oi.flight.getRawButton(RobotMap.armMoveDownFlightButton)) {
            armMoverMotor.set(-1);
        } else {
            armMoverMotor.set(0);
        }
    }
} 