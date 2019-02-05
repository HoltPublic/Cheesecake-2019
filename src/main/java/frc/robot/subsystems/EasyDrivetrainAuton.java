package frc.robot.subsystems;

import java.util.concurrent.TimeUnit;

public class EasyDrivetrainAuton {
	public static void easyAuton (double speed, String direction, long time) {
		//Drivetrain
		if (direction == "straight") {
            Drivetrain.leftVictorMaster.set(speed);
            Drivetrain.rightVictorMaster.set(speed);
			try {
				TimeUnit.SECONDS.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Drivetrain.leftVictorMaster.set(0);
            Drivetrain.rightVictorMaster.set(0);
		}		
		if (direction == "left") {
			Drivetrain.leftVictorMaster.set(speed);
            Drivetrain.rightVictorMaster.set(-speed);
			try {
				TimeUnit.SECONDS.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Drivetrain.leftVictorMaster.set(0);
            Drivetrain.rightVictorMaster.set(0);
		}	
		if (direction == "right") {
			Drivetrain.leftVictorMaster.set(-speed);
            Drivetrain.rightVictorMaster.set(speed);
			try {
				TimeUnit.SECONDS.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Drivetrain.leftVictorMaster.set(0);
            Drivetrain.rightVictorMaster.set(0);
		}
	}
}