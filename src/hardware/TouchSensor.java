package hardware;

import lejos.hardware.sensor.EV3TouchSensor;

public class TouchSensor {
    public static EV3TouchSensor getInstance() {
        return (EV3TouchSensor)DeviceType.TOUCH.get();
    }
}
