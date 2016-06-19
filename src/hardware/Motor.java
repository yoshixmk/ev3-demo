package hardware;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;

public class Motor {
    private static final EV3LargeRegulatedMotor motorFront = (EV3LargeRegulatedMotor) DeviceType.MOTOR_FRONT.get();
    private static final EV3LargeRegulatedMotor motorLeft = (EV3LargeRegulatedMotor) DeviceType.MOTOR_LEFT.get();
    private static final EV3LargeRegulatedMotor motorRight = (EV3LargeRegulatedMotor) DeviceType.MOTOR_RIGHT.get();
    private static final EV3MediumRegulatedMotor motorTail = (EV3MediumRegulatedMotor) DeviceType.MOTOR_TAIL.get();

    private BaseRegulatedMotor motor;

    public Motor(MotorType motorType) {
        switch (motorType) {
        case FRONT:
            setMotor(motorFront);
            break;
        case LEFT:
            setMotor(motorLeft);
            break;
        case RIGHT:
            setMotor(motorRight);
            break;
        case TAIL:
            setMotor(motorTail);
            break;
        }
    }

    public void setMotor(BaseRegulatedMotor motor) {
        this.motor = motor;
    }
    
    public void setMediumSpeed(){
        final int mediumSpeed = 70;
        motor.setSpeed(mediumSpeed);
    }
    
    public void rotateTo(int angle){
        motor.rotateTo(angle);
    }
    
    public void setSpeedAndForword(float speed){
        motor.setSpeed(speed);
        forword();
    }
    
    public void forword(){
        motor.forward();
//        motor.endSynchronization();
    }
}
