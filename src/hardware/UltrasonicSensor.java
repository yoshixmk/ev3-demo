package hardware;

import lejos.hardware.sensor.EV3UltrasonicSensor;

public class UltrasonicSensor {
    public static EV3UltrasonicSensor getInstance() {
        return (EV3UltrasonicSensor)DeviceType.ULTRASONIC.get();
    }
}
