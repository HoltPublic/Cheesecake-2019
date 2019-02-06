package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.InvertType;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Intake {
    //Making the Motors
    public static WPI_VictorSPX succBoiMaster = new WPI_VictorSPX(RobotMap.succBoiMasterCAN);
    public static WPI_VictorSPX succBoiSlave = new WPI_VictorSPX(RobotMap.succBoiSlaveCAN);
    
    //sets up the motors
    public static void IntakeSetup() {
        //sets them to the default settings
        succBoiMaster.configFactoryDefault();
        succBoiSlave.configFactoryDefault();

        //makes the slave follow the master
        succBoiSlave.follow(succBoiMaster);

        //Invert the motors incase it is backwards
        succBoiMaster.setInverted(false);
        succBoiSlave.setInverted(InvertType.FollowMaster);
    }

    //the class to spin the intake
    public static void IntakeRun() {
        if (Robot.oi.flight.getRawButton(RobotMap.intakeInButton)) {
            succBoiMaster.set(1);
        }
        else if (Robot.oi.flight.getRawButton(RobotMap.intakeOutButton)) {
            succBoiMaster.set(-1);
        }
        else {
            succBoiMaster.set(0);
        }
    }
} 