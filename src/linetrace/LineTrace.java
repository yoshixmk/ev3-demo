package linetrace;

import hardware.ColorSensor;
import hardware.Motor;
import hardware.MotorType;
import start.ColorThreshold;

public class LineTrace {
    private ColorThreshold threshold;
    ColorSensor colorSensor;
    Motor leftMotor;
    Motor rightMotor;
    PID pid;

    public LineTrace(ColorThreshold colorThreshold) {
        this.threshold = colorThreshold;
        colorSensor = new ColorSensor();
        leftMotor = new Motor(MotorType.LEFT);
        rightMotor = new Motor(MotorType.RIGHT);
        pid = new PID();
        pid.setKp(240.0F).setKi(180F).setKd(20F);
    }

    public void run() {
        float forward = 150.0F; // 前進命令
        float brightness = colorSensor.getBrightness();
        float turn = pid.pid(brightness, threshold.getBlackWhiteThreshold());

        leftMotor.setSpeedAndForword(forward + turn);
        rightMotor.setSpeedAndForword(forward - turn);
    }
}
