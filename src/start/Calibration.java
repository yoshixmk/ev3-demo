package start;

import java.util.HashMap;
import java.util.Map;

import hardware.TouchSensor;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;

public class Calibration {
    private EV3TouchSensor touchSensor;
    private Map<String, BaseRegulatedMotor> motors;

    public Calibration() {
        touchSensor = TouchSensor.getInstance();
        motors = new HashMap<String, BaseRegulatedMotor>() {
            private static final long serialVersionUID = 1L;
            {
                put("tail", new EV3LargeRegulatedMotor(MotorPort.A));
                put("left", new EV3LargeRegulatedMotor(MotorPort.B));
                put("right", new EV3LargeRegulatedMotor(MotorPort.C));
                put("front", new EV3LargeRegulatedMotor(MotorPort.D));
            }
        };
    }

    public void calibrate() {
        for(BaseRegulatedMotor m : motors.values()){
            int mediumSpeed = 70;
            m.setSpeed(mediumSpeed);
            int angle = 30;
            m.rotateTo(angle);
        }

        float[] touchValue = new float[touchSensor.sampleSize()];
        // 10秒間の実行
        for (int i = 0; i < 10000; i++) {
            touchSensor.fetchSample(touchValue, 0);
            LCD.drawString(String.valueOf(touchValue[0]), 0, 2);
            Delay.msDelay(1);
        }
    }
}
