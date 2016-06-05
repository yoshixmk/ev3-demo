package hardware;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class UltrasonicSensor {
    private static final EV3UltrasonicSensor eV3UltrasonicSensor = new EV3UltrasonicSensor(SensorPort.S3);

    private UltrasonicSensor() {
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            eV3UltrasonicSensor.close();
        }
    }

    public static EV3UltrasonicSensor getInstance() {
        return eV3UltrasonicSensor;
    }
}
