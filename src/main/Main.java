package main;

import lejos.hardware.lcd.LCD;
import start.Calibration;

public class Main {
    public static void main(String[] args) {
        LCD.drawString("Sensor Test!!", 0, 0);

        Calibration calibration = new Calibration();
        calibration.calibrate();
    }
}
