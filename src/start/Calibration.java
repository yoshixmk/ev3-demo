package start;

import java.util.ArrayList;
import java.util.List;

import hardware.ColorSensor;
import hardware.Motor;
import hardware.MotorType;
import hardware.TouchSensor;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Calibration {
    private TouchSensor touchSensor;
    private List<Motor> motors;
    private ColorThreshold colorThreshold;
    private ColorSensor colorSensor;

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
        colorSensor = new ColorSensor();
    }

    public void calibrate() {
        for (Motor m : motors) {
            m.setMediumSpeed();
            int angle = 25;
            m.rotateTo(angle);
        }

        float black = 0;
        float white = 0;
        while (!touchSensor.isTouched()) {
            black = colorSensor.getValue();
        }

        Delay.msDelay(10);
        while (touchSensor.isTouched());

        while (!touchSensor.isTouched()) {
            white = colorSensor.getValue();
        }

        colorThreshold = new ColorThreshold(black, white);

        // 10秒間の実行
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 10000){
            LCD.drawString(String.valueOf(touchSensor.isTouched()), 0, 2);
            LCD.drawString("black: " + black, 0, 3);
            LCD.drawString("white: " + white, 0, 4);
        }
    }
}
