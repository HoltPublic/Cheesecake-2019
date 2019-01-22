package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleboardData {
    //Tabs
    public static ShuffleboardTab mainTab = Shuffleboard.getTab("Main Tab");

    public static void SendShuffleboardData() {
        Shuffleboard.getTab("Main Tab").add("Distance", Sensors.getUltraBoiDistance());
    }
}