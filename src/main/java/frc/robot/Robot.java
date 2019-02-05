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

import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
  public static OI oi;

  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
    CameraServer.getInstance().startAutomaticCapture(); //starts the camera
    frc.robot.subsystems.Drivetrain.victorSetup(); //sets up the Victors
    frc.robot.subsystems.Pneumatics.pneumaticSetup(); //sets up the pneumatics
    frc.robot.subsystems.Sensors.SensorSetup(); //sets up the Sensors
    frc.robot.subsystems.Lifter.LifterSetup(); //sets up the Lifter
    frc.robot.subsystems.Intake.IntakeSetup(); //sets up the intake
  }

  @Override
  public void robotPeriodic() {
    frc.robot.subsystems.ShuffleboardData.SendShuffleboardData(); // to send data to computer
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
    frc.robot.subsystems.EasyDrivetrainAuton.easyAuton(.5, "straight", 10);
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
    frc.robot.subsystems.Pneumatics.hatchPusher(); //to push the hatch
    frc.robot.subsystems.Lifter.LifterMover(); //to move the lifter
    frc.robot.subsystems.Drivetrain.drive.arcadeDrive(Drivetrain.getDriveSpeed(), Drivetrain.getDriveRotation()); //So we can drive
    frc.robot.subsystems.Rumble.rumbleRun(); //test the rumble
    frc.robot.subsystems.Intake.IntakeRun(); //do intakey takey
  } /*
  ░░░░░░░░░░░░░░░░██████████████████ 
  ░░░░░░░░░░░░████░░░░░░░░░░░░░░░░░░████
  ░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██
  ░░░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██ 
  ░░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██
  ░░░░░░░░██░░░░░░░░░░░░░░░░░░░░██████░░░░██ 
  ░░░░░░░░██░░░░░░░░░░░░░░░░░░░░██████░░░░██
  ░░░░░░░░██░░░░██████░░░░██░░░░██████░░░░██
  ░░░░░░░░░░██░░░░░░░░░░██████░░░░░░░░░░██ 
  ░░░░░░░░████░░██░░░░░░░░░░░░░░░░░░██░░████ 
  ░░░░░░░░██░░░░██████████████████████░░░░██
  ░░░░░░░░██░░░░░░██░░██░░██░░██░░██░░░░░░██
  ░░░░░░░░░░████░░░░██████████████░░░░████ 
  ░░░░░░░░██████████░░░░░░░░░░░░░░██████████ 
  ░░░░░░██░░██████████████████████████████░░██ 
  ░░░░████░░██░░░░██░░░░░░██░░░░░░██░░░░██░░████
  ░░░░██░░░░░░██░░░░██████░░██████░░░░██░░░░░░██ 
  ░░██░░░░████░░██████░░░░██░░░░██████░░████░░░░██ 
  ░░██░░░░░░░░██░░░░██░░░░░░░░░░██░░░░██░░░░░░░░██
  ░░██░░░░░░░░░░██░░██░░░░░░░░░░██░░██░░░░░░░░░░██
  ░░░░██░░░░░░██░░░░████░░░░░░████░░░░██░░░░░░██ 
  ░░░░░░████░░██░░░░██░░░░░░░░░░██░░░░██░░████
  ░░░░░░░░██████░░░░██████████████░░░░██████ 
  ░░░░░░░░░░████░░░░██████████████░░░░████ 
  ░░░░░░░░██████████████████████████████████ 
  ░░░░░░░░████████████████░░████████████████ 
  ░░░░░░░░░░████████████░░░░░░████████████ 
  ░░░░░░██████░░░░░░░░██░░░░░░██░░░░░░░░██████ 
  ░░░░░░██░░░░░░░░░░████░░░░░░████░░░░░░░░░░██ 
  ░░░░░░░░██████████░░░░░░░░░░░░░░██████████ 
  */
  @Override
  public void testPeriodic() {
  }
}
