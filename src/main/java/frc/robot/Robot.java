/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {
  public static OI oi;

  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    // chooser.addOption("My Auto", new MyAutoCommand());
    new Thread(() -> {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(640, 480);
      
      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Tracking", 640, 480);
      
      Mat source = new Mat();
      Mat output = new Mat();
      
      while(!Thread.interrupted()) {
          cvSink.grabFrame(source);
          Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
          outputStream.putFrame(output);
      }
  }).start();

    SmartDashboard.putData("Auto mode", chooser);
    CameraServer.getInstance().startAutomaticCapture(); //starts the camera
    frc.robot.subsystems.Drivetrain.victorSetup(); //sets up the Victors
    frc.robot.subsystems.Pneumatics.pneumaticSetup(); //sets up the pneumatics
    frc.robot.subsystems.Sensors.SensorSetup(); //sets up the Sensors
    frc.robot.subsystems.Lifter.LifterSetup(); //sets up the Lifter
<<<<<<< HEAD
    frc.robot.subsystems.Intake.IntakeSetup();
=======
    frc.robot.subsystems.Intake.IntakeSetup(); //sets up the intake
>>>>>>> 2af29c1ced4d20c9a7bf6e1c766db6d7974c2fb9
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
    double yeet = 1;
    //frc.robot.subsystems.ShuffleboardData.SendShuffleboardData(); // to send data to computer
    frc.robot.subsystems.Pneumatics.hatchPusher(); //to push the hatch
    frc.robot.subsystems.Lifter.LifterMover(); //to move the lifter
    if(Robot.oi.xbox.getRawButton(1)) {
      yeet = .5;
    }
    else {
      yeet = 1;
    }
    frc.robot.subsystems.Drivetrain.drive.arcadeDrive(Robot.oi.getLeftJoyY() * yeet, Robot.oi.getLeftJoyX()); //So we can drive
  }

  @Override
  public void testPeriodic() {
  }
}
