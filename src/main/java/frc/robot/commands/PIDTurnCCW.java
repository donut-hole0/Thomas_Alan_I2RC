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
    public PIDTurnCCW(Drivetrain drivetrain, double targetAngle){
        this.drivetrain = drivetrain;
        this.setPointAngle = targetAngle;

        addRequirements(drivetrain);

        double maxOutput = 0.6; // change this motor output value as needed
        double maxError = 90.0; // total degrees that I want to reach
        double Kp = maxOutput/maxError;
        pidController = new PIDController(Kp, 0.0, 0.0);
        pidController.setSetpoint(setPointAngle);
        pidController.setTolerance(5.0); // + or - 5 degrees
    }

@Override
public void initialize(){
    drivetrain.reset();

    drivetrain.tankDrive(0,0);
}

public void execute(){
    double output = pidController.calculate(setPointAngle);
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