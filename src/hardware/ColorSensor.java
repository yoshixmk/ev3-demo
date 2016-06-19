package hardware;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class ColorSensor {
    private static final EV3ColorSensor COLOR = (EV3ColorSensor) DeviceType.COLOR.get();
    private SensorMode color = COLOR.getRedMode();
    private float[] colorSample;

    public ColorSensor() {
        colorSample = new float[color.sampleSize()];
    }

    public float getValue() {
        color.fetchSample(colorSample, 0);
        float value = colorSample[0];
        return value;
    }
}
