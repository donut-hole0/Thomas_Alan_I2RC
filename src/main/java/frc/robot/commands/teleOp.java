// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;


public class TeleOp extends Command {
  Joystick joystick;
  Drivetrain dt;

  public TeleOp(Drivetrain dt) {

    addRequirements(dt);
  }

  @Override
  public void initialize() {
    dt.tankDrive(0, 0);
  }
  @Override
  public void execute() {
    final double leftPowerRaw = joystick.getRawAxis(1);
    final double rightPowerRaw = joystick.getRawAxis(5);
    dt.tankDrive(leftPowerRaw, rightPowerRaw);
    SmartDashboard.putNumber("leftPower", leftPowerRaw);
    SmartDashboard.putNumber("rightPower", rightPowerRaw);
  }

  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0,0);

  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
