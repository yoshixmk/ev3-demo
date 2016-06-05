package hardware;

import lejos.hardware.Device;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public enum DeviceType {
    TOUCH("Touch"), ULTRASONIC("UltraSonic");

    private Device device;

    private DeviceType(String s) {
        if(device != null){
            return;
        }
        switch (s) {
        case "Touch":
            device = new EV3TouchSensor(SensorPort.S1);
            break;
        case "UltraSonic":
            device = new EV3UltrasonicSensor(SensorPort.S3);
            break;
        default:
            break;
        }
    }

    public Device get() {
        return device;
    }
}
