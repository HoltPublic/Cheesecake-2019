/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
  //The one and only Joystick so far
  public Joystick xbox = new Joystick(RobotMap.xboxUSB);
  public Joystick flight = new Joystick(RobotMap.flightStickUSB);

  //Controller Deadzone
  public static final double deadzone = 0.10;
  public static final double flightDeadzone = 0.30;

  //Buttons
  //xbox
  public Button slowBoiButton = new JoystickButton(xbox, RobotMap.slowBoiXboxButton);
  public Button yeetMeBackButton = new JoystickButton(xbox, RobotMap.yeetMeBackBoiXboxButton);
  public Button rumbleButton = new JoystickButton(xbox, RobotMap.rumbleTestXboxButton);
  public Button cameraSwitchButton = new JoystickButton(xbox, RobotMap.cameraSwitcherXboxButton);
  //flight stick
  public Button hatchPusherButton = new JoystickButton(flight, RobotMap.hatchPusherFlightButton);
  public Button intakeInButton = new JoystickButton(flight, RobotMap.intakeInFlightButton);
  public Button intakeOutButton = new JoystickButton(flight, RobotMap.intakeOutFlightButton);
  public Button armMoveUpButton = new JoystickButton(flight, RobotMap.armMoveUpFlightButton);
  public Button armMoveDownButton = new JoystickButton(flight, RobotMap.armMoveDownFlightButton);
  public Button hatchOpenButton = new JoystickButton(flight, RobotMap.hatchLatchFlightOpenButton);
  public Button hatchCloseButton = new JoystickButton(flight, RobotMap.hatchLatchFlightCloseButton);

  //Classes to get the values of the left joystick of the xBox Controller
  public double getLeftJoyX() {
    double raw = xbox.getX(Hand.kLeft);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }
  public double getLeftJoyY() {
    double raw = xbox.getY(Hand.kLeft);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }

  //Classes to get the Values of the right joystick of the xBox controller
  public double getRightJoyX() {
    double raw = xbox.getX(Hand.kRight);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }
  public double getRightJoyY() {
    double raw = xbox.getY(Hand.kRight);
    return Math.abs(raw) < deadzone ? 0.0 : raw;
  }

  //Class to get the Values of the flightstick
  public double getFlightJoyX() {
    double raw = flight.getX();
    return Math.abs(raw) < flightDeadzone ? 0.0 : raw;
  }
  public double getFlightJoyY() {
    double raw = flight.getY();
    return Math.abs(raw) < flightDeadzone ? 0.0 : raw;
  }
}