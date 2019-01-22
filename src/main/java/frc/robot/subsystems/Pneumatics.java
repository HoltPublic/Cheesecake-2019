package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics {
    //Compressor
    public static Compressor mainCompressor = new Compressor(RobotMap.PCMCAN);

    //Solenoids
    public static DoubleSolenoid hatchPusherSolenoid = new DoubleSolenoid(RobotMap.hatchPusher0PCM, RobotMap.hatchPusher1PCM);

    //Things to make sure the pneumatics work
    public static void pneumaticSetup() {
        mainCompressor.setClosedLoopControl(true);
    }

     //Hatch Pusher
     public static void hatchPusher() {
        if(Robot.oi.xbox.getRawButton(RobotMap.xboxHatchPusherButton)) {
            hatchPusherSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        else {
            hatchPusherSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
    }
}