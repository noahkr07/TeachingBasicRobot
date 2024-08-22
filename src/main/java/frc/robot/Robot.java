package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {
  public TalonSRX rightFront;
  public TalonSRX leftFront;
  public TalonSRX rightBack;
  public TalonSRX leftBack;

  public XboxController controller;

  @Override
  public void robotInit() {
    rightFront = new TalonSRX(1);
    leftFront = new TalonSRX(3);
    leftBack = new TalonSRX(4);
    rightBack = new TalonSRX(2);

    rightFront.setInverted(InvertType.InvertMotorOutput);
    rightBack.setInverted(InvertType.InvertMotorOutput);
    leftBack.set(ControlMode.Follower, 3);
    rightBack.set(ControlMode.Follower, 1);
    
    rightFront.setNeutralMode(NeutralMode.Coast);
    rightBack.setNeutralMode(NeutralMode.Coast);
    leftFront.setNeutralMode(NeutralMode.Coast);
    leftBack.setNeutralMode(NeutralMode.Coast);

    controller = new XboxController(0);
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    rightFront.set(ControlMode.PercentOutput, controller.getRightY());
    leftFront.set(ControlMode.PercentOutput, controller.getLeftY());
  }  
}
