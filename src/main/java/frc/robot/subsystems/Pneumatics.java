package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
    //Making the Compressor
    public static Compressor mainCompressor = new Compressor(RobotMap.PCMCAN);

    //Making the Solenoids
    public static DoubleSolenoid hatchPusherSolenoid = new DoubleSolenoid(RobotMap.hatchPusher0PCM, RobotMap.hatchPusher1PCM);
    public static Solenoid lift = new Solenoid(2);

    //Sets up the Compressor
    public static void pneumaticSetup() {
        mainCompressor.setClosedLoopControl(true);
    }

     //Pushes the hatch when you press the trigger on the flightstick
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