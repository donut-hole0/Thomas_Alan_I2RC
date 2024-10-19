package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.internal.DriverStationModeThread;

public class PIDTurnCCW extends Command{
    // declaring variables
    private final double setPointAngle;
    private final Drivetrain drivetrain;
    private final PIDController pidController;

    // constructor
    public PIDTurnCCW(Drivetrain dt, double setPoint, PIDController pid){
        drivetrain = dt;
        setPointAngle = setPoint;
        pidController = pid;
        addRequirements(dt);
        pid.setTolerance(5.0);


    }

@Override
public void initialize(){
    drivetrain.resetNavx();
    drivetrain.tankDrive(0,0);
}

public void execute(){
    double output = pidController.calculate(drivetrain.getAngle(), setPointAngle);
    drivetrain.tankDrive(output, -output);
}

public void end(boolean interrupted){
    drivetrain.tankDrive(0, 0);
}

@Override
public boolean isFinished(){
    return pidController.atSetpoint();
}
}