/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1983.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1983.Robot;


/**
 * An example command.  You can replace me with your own command.
 */
public class TankDrive extends Command
{
    private Robot exCaliper;
    public TankDrive()
    {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.getInstance().getDriveBase());
    }

    /**
     * The initialize method is called just before the first time 
     * this Command is run after being started.
     */
    @Override
    protected void initialize()
    {
        exCaliper = Robot.getInstance();
    }


    /**
     * The execute method is called repeatedly when this Command is 
     * scheduled to run until this Command either finishes or is canceled.
     */
    @Override
    protected void execute()
    {
        double leftJoy = exCaliper.getOi().getLeftJoy();
        double rightJoy = exCaliper.getOi().getRightJoy();

        exCaliper.getDriveBase().setLeftSpeed(scaleJoy(leftJoy));
        exCaliper.getDriveBase().setRightSpeed(scaleJoy(rightJoy));
    }

    private double scaleJoy(double joyValue)
    {
        if(joyValue<0)
        {
            return -(joyValue*joyValue);
        }
        else
        {
            return (joyValue*joyValue);
        }
    }


    /**
     * <p>
     * Returns whether this command is finished. If it is, then the command will be removed and 
     * {@link #end()} will be called.
     * </p><p>
     * It may be useful for a team to reference the {@link #isTimedOut()}
     * method for time-sensitive frc.team1983.commands.
     * </p><p>
     * Returning false will result in the command never ending automatically. It may still be
     * cancelled manually or interrupted by another command. Returning true will result in the
     * command executing once and finishing immediately. It is recommended to use 
     * {@link edu.wpi.first.wpilibj.command.InstantCommand} (added in 2017) for this.
     * </p>
     *
     * @return whether this command is finished.
     *
     * @see Command#isTimedOut() isTimedOut()
     */
    @Override
    protected boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }


    /**
     * Called once when the command ended peacefully; that is it is called once 
     * after {@link #isFinished()} returns true. This is where you may want to 
     * wrap up loose ends, like shutting off a motor that was being used in the 
     * command.
     */
    @Override
    protected void end()
    {
            
    }

    
    /**
     * <p>
     * Called when the command ends because somebody called {@link #cancel()} or
     * another command shared the same requirements as this one, and booted it out. For example,
     * it is called when another command which requires one or more of the same
     * frc.team1983.commands.subsystems is scheduled to run.
     * </p><p>
     * This is where you may want to wrap up loose ends, like shutting off a motor that was being
     * used in the command.
     * </p><p>
     * Generally, it is useful to simply call the {@link #end()} method within this
     * method, as done here.
     * </p>
     */
    @Override
    protected void interrupted()
    {
        super.interrupted();
    }
}
