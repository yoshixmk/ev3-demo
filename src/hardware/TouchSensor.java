package hardware;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;

public class TouchSensor {
    private static final EV3TouchSensor ev3TouchSensor = new EV3TouchSensor(SensorPort.S1);

    private TouchSensor() {
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            ev3TouchSensor.close();
        }
    }

    public static EV3TouchSensor getInstance() {
        return ev3TouchSensor;
    }
}
