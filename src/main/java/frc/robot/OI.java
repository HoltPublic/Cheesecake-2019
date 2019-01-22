/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {
  //The one and only Joystick so far
  public Joystick xbox = new Joystick(RobotMap.xboxUSB);

  //Controller Deadzone
  public static final double deadzone = 0.10;

  //Classes to get the values of the left joystick of the Controller
  public double getLeftJoyX() {
    double raw = xbox.getX(Hand.kLeft);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }
  public double getLeftJoyY() {
    double raw = xbox.getY(Hand.kLeft);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }

  //Classes to get the Values of the right joystick of the controller
  public double getRightJoyX() {
    double raw = xbox.getX(Hand.kRight);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }
  public double getRightJoyY() {
    double raw = xbox.getY(Hand.kRight);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }
}
