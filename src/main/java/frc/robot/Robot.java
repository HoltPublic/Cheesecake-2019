/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
  public static OI oi;
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String autoSelected;
  private final SendableChooser<String> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    chooser.setDefaultOption("Default Auto", kDefaultAuto);
    chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", chooser);
    CameraServer.getInstance().startAutomaticCapture(); //starts the camera
    frc.robot.subsystems.Drivetrain.DrivetrainSetup(); //sets up the drivetrain
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
  public void autonomousInit() {
    autoSelected = chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
    switch (autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopPeriodic() {
    frc.robot.subsystems.Pneumatics.hatchPusher(); //to push the hatch
    frc.robot.subsystems.Lifter.LifterMover(); //to move the lifter
    frc.robot.subsystems.Drivetrain.drive.arcadeDrive(Drivetrain.getDriveSpeed(), Drivetrain.getDriveRotation()); //So we can drive
    frc.robot.subsystems.Rumble.rumbleRun(); //test the rumble
    frc.robot.subsystems.Intake.IntakeRun(); //to run the intake
  }

  @Override
  public void testPeriodic() {
  }
}
/*
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
  *///god to help our robot