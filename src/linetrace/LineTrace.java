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

    public LineTrace(ColorThreshold colorThreshold) {
        this.threshold = colorThreshold;
        colorSensor = new ColorSensor();
        leftMotor = new Motor(MotorType.LEFT);
        rightMotor = new Motor(MotorType.RIGHT);
    }

    public void run() {
        float forward = 100.0F; // 前進命令
        float turn;
        if (colorSensor.getBrightness() > threshold.getBlackWhiteThreshold()) {
            turn = 80.0F; // 右旋回命令
        } else {
            turn = -80.0F; // 左旋回命令
        }

        leftMotor.setSpeedAndForword(forward + turn);
        rightMotor.setSpeedAndForword(forward - turn);
    }
}
