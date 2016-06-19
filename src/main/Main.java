package main;

import lejos.hardware.lcd.LCD;
import linetrace.LineTrace;
import start.Calibration;
import start.ColorThreshold;

public class Main {
    public static void main(String[] args) {
        LCD.drawString("Sensor Test!!", 0, 0);

        Calibration calibration = new Calibration();
        calibration.calibrate();
        ColorThreshold colorThreshold = calibration.getColorThreshold();
        LineTrace lineTrace = new LineTrace(colorThreshold);
        // 20秒間の実行
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 20000) {
            lineTrace.run();
        }
    }
}
