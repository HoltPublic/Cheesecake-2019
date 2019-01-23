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

  //Lifter we named it Scotty
  public static int liftMeUpScottyCAN = 15;

  //Pneumatic
  public static int PCMCAN = 0;
  public static int hatchPusher0PCM = 0;
  public static int hatchPusher1PCM = 1;

  //Controllers
  public static int xboxUSB = 0;
  public static int flightStickUSB = 1;

  //Sensors
  public static int ultrasonicInputDIO = 0;
  public static int ultrasonicOutputDIO = 1;

  //Controllor buttons
  public static int xboxHatchPusherButton = 5;
}
