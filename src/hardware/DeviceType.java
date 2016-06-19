package hardware;

import lejos.hardware.Device;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public enum DeviceType {
    TOUCH("Touch"), ULTRASONIC("UltraSonic"), COLOR("Color"), GYRO("Gyro");

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
        case "Color":
            device = new EV3ColorSensor(SensorPort.S2);
            break;
        case "Gyro":
            device = new EV3GyroSensor(SensorPort.S4);
            break;
        default:
            throw new IllegalArgumentException();
        }
    }

    public Device get() {
        return device;
    }
}
