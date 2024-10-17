# Preseason Digital Notebook Example
Name: Alan Thomas

Section: I2RC

Week: 3


## Code

The main topic this week was: PID lab

Commands: 
calculate()
reset()
PIDController
setTolerance() method
atSetpoint() method



Subsystems: Not sure

### How does the code work?
This class (PIDTurnCCW) is designed to turn the robot counterclockwise to a specific angle (setPointAngle) using PID. This week we are only focusing on the proportional part of PID. So, we are only using the component Kp. As I stated before, setPointAngle is the desired angle and result of this code. The Kp calculation is based on the maximum output and maximum error from the target turn angle. But, we also set a tolerance of 5 degrees using setTolerance(5.0). The intialize() method starts the command and stops any movement by setting the motor speeds to 0, tankDrive(0,0). The execute method is the main method as it is the bulk of the result. I tried to use calculate() to get the amount of power needed based on Kp. tankDrive(output, -output) allows the motor to turn based on outputs. When the robot is within 5 degrees of the target angle, the command ends and the motors stop.


### Important notes for future reference
commands used in this lab - https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/pidcontroller.html
