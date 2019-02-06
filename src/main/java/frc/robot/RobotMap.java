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
  public static int liftMeUpScottyCAN = 15;

  //Intake
  public static int succBoiMasterCAN = 17;
  public static int succBoiSlaveCAN = 18;

  //Pneumatic
  public static int PCMCAN = 0;
  public static int hatchPusher0PCM = 0;
  public static int hatchPusher1PCM = 1;

  //Controllers
  public static int xboxUSB = 0;
  public static int flightStickUSB = 1;

  //Sensors
  public static int intakeStopSwitchDIO = 0;
  public static int halleffectTopBoi = 1;
  public static int halleffectBottomBoi = 2;

  //Controllor buttons
  public static int flightHatchPusherButton = 1;
  public static int slowBoiButton = 1;
  public static int rumbleTestButton = 4;
  public static int intakeInButton = 3;
  public static int intakeOutButton = 4;

}
