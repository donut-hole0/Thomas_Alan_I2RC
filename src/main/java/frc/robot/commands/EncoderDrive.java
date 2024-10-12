package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

public class EncoderDrive extends Command {

  private final Drivetrain drivetrain;
  private final double setpoint;
  public EncoderDrive(Drivetrain drivetrain, double setpoint) {
    this.drivetrain = drivetrain;
    this.setpoint = setpoint;
    addRequirements(drivetrain);

  }
  
  public void initialize() {
    drivetrain.resetEncoders();
    drivetrain.tankDrive(0, 0);
  }

  public void execute() {
    double currentPosition = drivetrain.getMeters();
    double error = setpoint - currentPosition;
    double speedOfRobot = error * 0.1;
    double speed = Math.max(Math.min(speedOfRobot, 1.0), -1.0);
    drivetrain.tankDrive(speed, speed);
  }

  @Override
  //Check to see if isFinished is False
  public boolean isFinished() {
    double currentPosition = drivetrain.getMeters();
    return Math.abs(setpoint - currentPosition) < 0.05; 
    //Checks to see if robot is 5 cm within range of the setpoint
  }
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0,0);
  }
}