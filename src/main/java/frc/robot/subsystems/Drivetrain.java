package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;
import frc.robot.RobotMap;
public class Drivetrain {
    //Making the motors
    //Masters
    public static WPI_VictorSPX rightVictorMaster = new WPI_VictorSPX(RobotMap.rightVictorMasterCAN);
    public static WPI_VictorSPX leftVictorMaster = new WPI_VictorSPX(RobotMap.leftVictorMasterCAN);
    //Slaves
    public static WPI_VictorSPX rightVictorSlave = new WPI_VictorSPX(RobotMap.rightVicrotSlaveCAN);
    public static WPI_VictorSPX leftVictorSlave = new WPI_VictorSPX(RobotMap.leftVictorSlaveCAN);

    //Differential Drive
    public static DifferentialDrive drive = new DifferentialDrive(leftVictorMaster, rightVictorMaster);

    //Sets up the motors
    public static void DrivetrainSetup() {
        //Reset the victors to the default settings
        rightVictorMaster.configFactoryDefault();
        rightVictorSlave.configFactoryDefault();
        leftVictorMaster.configFactoryDefault();
        leftVictorSlave.configFactoryDefault();

        //Follow so the slaves follow the master
        rightVictorSlave.follow(rightVictorMaster);
        leftVictorSlave.follow(leftVictorMaster);

        //Invert the motors incase it is backwards
        //if robot does not drive stright try changing the invert first then the right side invert at the bottom
        //dont change this it drives good
        rightVictorMaster.setInverted(true);
        rightVictorSlave.setInverted(InvertType.FollowMaster);
        leftVictorMaster.setInverted(false);
        leftVictorSlave.setInverted(InvertType.FollowMaster);

        //fixes the thing where the right side is said to be negative
        Drivetrain.drive.setRightSideInverted(false);
    }

    //Gets the value of the joystick and returns it
    //makes the robot drive at half speed when you press the button
    public static double getDriveSpeed() {
        double raw;
        if (Robot.oi.xbox.getRawButton(RobotMap.slowBoiButton)){
            raw = Robot.oi.getLeftJoyY() * .5;
        }
        else if(Robot.oi.xbox.getRawButton(RobotMap.yeetMeBackBoiButton)){
            raw = Robot.oi.getLeftJoyY() * -1;
        }
        else if(Robot.oi.xbox.getRawButton(RobotMap.slowBoiButton) && Robot.oi.xbox.getRawButton(RobotMap.yeetMeBackBoiButton)){
            raw = Robot.oi.getLeftJoyY() -.5;
        }
        else{
            raw = Robot.oi.getLeftJoyY();
        }
        return raw;
    }

    //Gets the value of the joystick and returns it
    public static double getDriveRotation() {
        double raw;
        if (Robot.oi.xbox.getRawButton(RobotMap.slowBoiButton)){
            raw = Robot.oi.getLeftJoyX() * .5;
        }
        else{
            raw = Robot.oi.getLeftJoyX();
        }
        return raw;
    }
}