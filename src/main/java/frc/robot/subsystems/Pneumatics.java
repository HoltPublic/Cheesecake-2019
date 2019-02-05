package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
    //Compressor
    public static Compressor mainCompressor = new Compressor(RobotMap.PCMCAN);

    //Solenoids
    public static DoubleSolenoid hatchPusherSolenoid = new DoubleSolenoid(RobotMap.hatchPusher0PCM, RobotMap.hatchPusher1PCM);
    public static Solenoid lift = new Solenoid(2);

    //Things to make sure the pneumatics work
    public static void pneumaticSetup() {
        mainCompressor.setClosedLoopControl(true);
    }

     //Hatch Pusher
     public static void hatchPusher() {
        if(Robot.oi.flight.getRawButton(RobotMap.flightHatchPusherButton)) {
            hatchPusherSolenoid.set(DoubleSolenoid.Value.kForward);
            lift.set(true);
        }
        else {
            hatchPusherSolenoid.set(DoubleSolenoid.Value.kReverse);
            lift.set(false);
        }
        
    }
}