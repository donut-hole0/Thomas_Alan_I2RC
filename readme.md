## Preseason Digital Notebook
Name: Alan Thomas

Section: I2RC

<<<<<<< HEAD
Week: 2
=======
Week: 3
>>>>>>> W3.PID


## Code

<<<<<<< HEAD
The main topic this week was: Encoder Lab and PID

Commands: 
initialize()
execute()
end(boolean interrupted)
Command


Subsystems: Not sure

### How does the code work?
The code is used to track motor movements with precision, while giving feedback on how fast/far something is moving. getTicks() and getMeters() work hand in hand to give us the distance in ticks and meters of how far the robot is going. The EncoderDrive class has a parameter called setpoint which marks the expected distance needed to go to. The execute() method should allow the robot to this setpoint and reach near the expected distance. isFinished() will allow the robot to stop once at the expected distance (setpoint). Actually, wait no, isFinished() return a boolean that will tell the robot, "Hey we reached the distance" and return False. Using this, we can add an end() method to make sure the robot stops once at or near the expected distance. end() sets the speed of the robot to 0, making sure the robot stops. Note: I am not sure how to set EncoderDrive as my default command.


### Important notes for future reference
class signature meaning - https://bito.ai/resources/java-class-signature-java-explained/

commands used in this lab - https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html
=======
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
>>>>>>> W3.PID
