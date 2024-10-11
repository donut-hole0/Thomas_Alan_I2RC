// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftDriveTalon;
  private final WPI_TalonSRX rightDriveTalon;
  private AHRS navx = new AHRS(SPI.Port.kMXP);
  
  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    leftDriveTalon = new WPI_TalonSRX(Constants.Drivetrain_Ports.leftDriveTalonPort);
    rightDriveTalon = new WPI_TalonSRX(Constants.Drivetrain_Ports.rightDriveTalonPort);
    leftDriveTalon.setNeutralMode(NeutralMode.Coast);
    rightDriveTalon.setNeutralMode(NeutralMode.Coast);
    
    rightDriveTalon.setInverted(true);
    leftDriveTalon.setSensorPhase(true);
    rightDriveTalon.setSensorPhase(true);

    leftDriveTalon.configFactoryDefault();
    leftDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    rightDriveTalon.configFactoryDefault();
    rightDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftDriveTalon.set(leftSpeed);
    rightDriveTalon.set(rightSpeed);
  }
  public double getAngle(){
    return navx.getAngle();
  }
  public void reset(){
    navx.reset();
  }

  public double getSelectedSensorPosition() {
    double leftPosition = leftDriveTalon.getSelectedSensorPosition(0);
    double rightPosition = rightDriveTalon.getSelectedSensorPosition(0);
    double averagePosition = (leftPosition + rightPosition) / 2.0;
    return averagePosition;
  }

  private static final double wheelDiameterInch = 6.0;
  private static final int ticksPerRotation = 4096;

  public double getMeters(double ticks){
    double circumferenceWheel = Math.PI * wheelDiameterInch;
    double inchToMeter = circumferenceWheel * 0.0254;
    double distancePerTick = inchToMeter/ticksPerRotation;
    double ticksToMeters = ticks * distancePerTick;
    return ticksToMeters;
  }

  public void resetEncoders(){
    leftDriveTalon.setSelectedSensorPosition(0,0,10);
    rightDriveTalon.setSelectedSensorPosition(0,0,10);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Voltage", leftDriveTalon.getMotorOutputPercent());
    SmartDashboard.putNumber("Right VOltage", rightDriveTalon.getMotorOutputPercent());
    SmartDashboard.putNumber("Angle", navx.getAngle());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}