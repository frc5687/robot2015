package org.usfirst.frc.team5687.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Operator interface for the robot, tying user controls to robot commands
 */
public class OI {
	private Gamepad gamepad;
	private Joystick joystick;
	
	/*
	 * Constructor
	 */
	public OI() {
		gamepad = new Gamepad(0);
		joystick = new Joystick(1);
	}
	
	/*
	 * Returns the control value for the left drive motors
	 * @return double the desired speed value for the left drive motors
	 */
	public double getLeftDriveValue() {
		// Return the vertical left-stick axis value from the gamepad
		double raw = gamepad.getRawAxis(Gamepad.Axes.LEFT_Y);
		return Util.applyDeadband(raw, RobotFactors.Deadbands.DRIVE_STICK);
	}
	
	/*
	 * Returns the control value for the right drive motors
	 * @return double the desired speed value for the right drive motors
	 */
	public double getRightDriveValue() {
		// Return the vertical right-stick axis value for the gamepad
		double raw = gamepad.getRawAxis(Gamepad.Axes.RIGHT_Y);
		return Util.applyDeadband(raw, RobotFactors.Deadbands.DRIVE_STICK);
	}
	
	/*
	 * Checks if the driver wants to override the internal speed limit
	 * @return boolean true if the driver wants to override the speed limit
	 */
	public boolean getOverrideButtonValue() {
		return gamepad.getRawButton(Gamepad.Buttons.RB);
	}
	
	/*
	 * Returns the control value for the stacker elevation
	 * @return double the desired speed for the stacker motor
	 */
	public double getStackerValue() {
		return Util.applyDeadband(joystick.getRawAxis(1), RobotFactors.Deadbands.LIFT_STICK);
	}
}

