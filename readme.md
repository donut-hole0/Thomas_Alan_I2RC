## Preseason Digital Notebook
Name: Alan Thomas

Section: I2RC

Week: 2


## Code

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
