/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  //Drivetrain
  public static int leftVictorMasterCAN = 11;
  public static int leftVictorSlaveCAN = 12;
  public static int rightVictorMasterCAN = 13;
  public static int rightVicrotSlaveCAN = 14;

  //Lifter I named it Scotty
  public static int liftMeUpScottyCAN = 16;
  public static int hatchLatchCAN = 19;

  //Intake
  public static int succBoiTopCAN = 15;
  public static int succBoiBottomCAN = 17;
  public static int armMoverCAN = 18;

  //Pneumatic
  public static int PCMCAN = 0;
  public static int hatchPusher0PCM = 0;
  public static int hatchPusher1PCM = 1;

  //Controllers
  public static int xboxUSB = 0;
  public static int flightStickUSB = 1;

  //Sensors
  public static int hatchStopTopDIO = 0;
  public static int hatchStopBottomDIO = 1;

  //Xbox buttons
  public static int slowBoiXboxButton = 1;
  public static int rumbleTestXboxButton = 4;
  public static int yeetMeBackBoiXboxButton = 5;
  public static int cameraSwitcherXboxButton = 5;

  //Flightstick buttons
  public static int hatchPusherFlightButton = 1;
  public static int intakeInFlightButton = 6;
  public static int intakeOutFlightButton = 9;
  public static int armMoveUpFlightButton = 5;
  public static int armMoveDownFlightButton = 10;
  public static int hatchLatchFlightOpenButton = 3;
  public static int hatchLatchFlightCloseButton = 4;
  public static int ballIntakeInFastButton = 11;
}