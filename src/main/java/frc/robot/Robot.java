/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  public static OI oi;

  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
    frc.robot.subsystems.Drivetrain.victorSetup(); //sets up the Victors
    frc.robot.subsystems.Pneumatics.pneumaticSetup(); //sets up the pneumatics
    frc.robot.subsystems.Sensors.SensorSetup(); //sets up the Sensors
    frc.robot.subsystems.Lifter.LifterSetup(); //sets up the Lifter
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = chooser.getSelected();
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    frc.robot.subsystems.ShuffleboardData.SendShuffleboardData(); // to send data to computer
    frc.robot.subsystems.Drivetrain.drive.arcadeDrive(Robot.oi.getLeftJoyY(), Robot.oi.getLeftJoyX()); //So we can drive
    frc.robot.subsystems.Pneumatics.hatchPusher(); //to push the hatch
    frc.robot.subsystems.Lifter.LifterMover(); //to move the lifter
  }

  @Override
  public void testPeriodic() {
  }
}
// I do the show to neelam of do how push to git hub