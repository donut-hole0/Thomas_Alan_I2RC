package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.internal.DriverStationModeThread;

public class PIDTurnCCW extends Command{
    // declaring variables
    double setPointAngle;
    Drivetrain drivetrain;
    PIDController pidController = new PIDController(0.7/90, 0, 0);

    // constructor
    public PIDTurnCCW(Drivetrain dt, double setPoint){
        drivetrain = dt;
        setPointAngle = setPoint;
        addRequirements(dt);
        pidController.setTolerance(5.0);


    }

@Override
public void initialize(){
    drivetrain.resetNavx();
    drivetrain.tankDrive(0,0);
}

public void execute(){
    double output = pidController.calculate(drivetrain.getAngle(), setPointAngle);
    drivetrain.tankDrive(-output, output);
}

public void end(boolean interrupted){
    drivetrain.tankDrive(0, 0);
}

@Override
public boolean isFinished(){
    return pidController.atSetpoint();
}
}