package frc.robot;

import java.util.concurrent.TimeUnit;

public class AutonDrive {
    public static void AutonDrivetrain(String direction, Double speed, long time) {
        if(direction == "forward") {
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(speed);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(speed);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(0);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(0);
        }

        if(direction == "right") {
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(-speed);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(speed);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(0);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(0);
        }

        if(direction == "left") {
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(speed);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(-speed);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(0);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(0);
        }

        if(direction == "back") {
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(-speed);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(-speed);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Drivetrain.leftVictorMaster.set(0);
            frc.robot.subsystems.Drivetrain.rightVictorMaster.set(0);
        }
    }

    public static void AutonIntake(String inOrOut, long time){
        if(inOrOut == "in"){
            frc.robot.subsystems.Intake.succBoiTop.set(.75);
            frc.robot.subsystems.Intake.succBoiBottom.set(.75);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Intake.succBoiTop.set(0);
            frc.robot.subsystems.Intake.succBoiBottom.set(0);
        }
        if(inOrOut == "out"){
            frc.robot.subsystems.Intake.succBoiTop.set(-.75);
            frc.robot.subsystems.Intake.succBoiBottom.set(-.75);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Intake.succBoiTop.set(0);
            frc.robot.subsystems.Intake.succBoiBottom.set(0);
        }
    }

    public static void AutonArm(String upOrDown){
        if(upOrDown == "up"){
            frc.robot.subsystems.Intake.armMoverMotor.set(.5);
            try{
                TimeUnit.SECONDS.sleep(8);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Intake.armMoverMotor.set(0);
        }
        if(upOrDown == "down"){
            frc.robot.subsystems.Intake.armMoverMotor.set(-.5);
            try{
                TimeUnit.SECONDS.sleep(8);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            frc.robot.subsystems.Intake.armMoverMotor.set(0);
        }
    }
}