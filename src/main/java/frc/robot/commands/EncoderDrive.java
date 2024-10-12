package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class EncoderDrive extends Command{

  private final Drivetrain dt;
  private final double setpoint;
  
  public EncoderDrive(Drivetrain dt, double setpoint) {
    this.dt = dt;
    this.setpoint = setpoint;
    addRequirements(dt);

  }
  
  public void initialize() {
    dt.resetEncoders();
    dt.tankDrive(0, 0);
  }

  public void execute() {
    dt.tankDrive(0.3, 0.3);
  }

  @Override
  //Check to see if isFinished is False
  public boolean isFinished() {
    if(dt.getMeters() >= setpoint){
      return true;
    }
    else return false;
    //Checks to see if robot is 5 cm within range of the setpoint
  }
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0,0);
  }
}