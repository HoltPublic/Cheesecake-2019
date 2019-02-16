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

        //Invert the motors incase it is backwards
        succBoiTop.setInverted(false);
        succBoiBottom.setInverted(false);
        armMoverMotor.setInverted(false);
    }

    //the class to spin the intake
    public static void BallIntake() {
        int InDirection = 1;
        int OutDirection = -1;
        int Stop = 0;
        
        if (Robot.oi.flight.getRawButton(RobotMap.intakeInFlightButton)) {
            succBoiTop.set(InDirection);
            succBoiBottom.set(InDirection);
        }
        else if (Robot.oi.flight.getRawButton(RobotMap.intakeOutFlightButton)) {
            succBoiTop.set(OutDirection);
            succBoiBottom.set(OutDirection);
        }
        else {
            succBoiTop.set(Stop);
            succBoiBottom.set(Stop);
        }
    }

    //moves the arm that the intake in on
    public static void ArmMover() {
        int UpDirection = 1;
        int DownDirection = 1;
        int Stop = 0;

        if (Robot.oi.flight.getRawButton(RobotMap.armMoveUpFlightButton)) {
            armMoverMotor.set(UpDirection);
        } else if (Robot.oi.flight.getRawButton(RobotMap.armMoveDownFlightButton)) {
            armMoverMotor.set(DownDirection);
        } else {
            armMoverMotor.set(Stop);
        }
    }
} 