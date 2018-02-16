/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1983.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.team1983.commands.TankDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveBase extends Subsystem
{
    TalonSRX Left[] = new TalonSRX[3];
    TalonSRX Right[] = new TalonSRX[3];

    public void initDefaultCommand()
    {
        // TODO: Set the default command for a subsystem here. Example:
        setDefaultCommand(new TankDrive());
    }

    public DriveBase()
    {
        Left[0] = new TalonSRX(0);
        Left[1] = new TalonSRX(1);
        Left[2] = new TalonSRX(12);

        Right[0] = new TalonSRX(13);
        Right[1] = new TalonSRX(14);
        Right[2] = new TalonSRX(15);
    }

    public void setLeftSpeed(double Speed)
    {
        Left[0].set(ControlMode.PercentOutput, -Speed);
        Left[1].set(ControlMode.PercentOutput, -Speed);
        Left[2].set(ControlMode.PercentOutput, -Speed);
    }

    public void setRightSpeed(double Speed)
    {
        Right[0].set(ControlMode.PercentOutput, Speed);
        Right[1].set(ControlMode.PercentOutput, Speed);
        Right[2].set(ControlMode.PercentOutput, Speed);
    }
}
