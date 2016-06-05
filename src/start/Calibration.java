package start;

import hardware.TouchSensor;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;

public class Calibration {
    private EV3TouchSensor ev3TouchSensor;

    public Calibration() {
        ev3TouchSensor = TouchSensor.getInstance();
    }

    public void calibrate() {
        float[] touchValue = new float[ev3TouchSensor.sampleSize()];
        
        // 10秒間の実行
        for (int i = 0; i < 10000; i++) {
            ev3TouchSensor.fetchSample(touchValue, 0);
            LCD.drawString(String.valueOf(touchValue[0]), 0, 2);
            Delay.msDelay(1);
        }
    }
}
