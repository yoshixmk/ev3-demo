package start;

import java.util.ArrayList;
import java.util.List;

import hardware.Motor;
import hardware.MotorType;
import hardware.TouchSensor;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Calibration {
    private TouchSensor touchSensor;
    private List<Motor> motors;

    public Calibration() {
        motors = new ArrayList<Motor>() {
            private static final long serialVersionUID = 1L;
            {
                add(new Motor(MotorType.FRONT));
                add(new Motor(MotorType.LEFT));
                add(new Motor(MotorType.RIGHT));
                add(new Motor(MotorType.TAIL));
            }
        };
        touchSensor = new TouchSensor();
    }

    public void calibrate() {
        for (Motor m : motors) {
            m.setMediumSpeed();
            int angle = 30;
            m.rotateTo(angle);
        }

        // 10秒間の実行
        for (int i = 0; i < 10000; i++) {
            LCD.drawString(String.valueOf(touchSensor.isTouched()), 0, 2);
            Delay.msDelay(1);
        }
    }
}
