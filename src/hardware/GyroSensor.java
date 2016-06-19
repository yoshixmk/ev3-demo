package hardware;

import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

public class GyroSensor {
    private static final EV3GyroSensor GYRO = (EV3GyroSensor) DeviceType.GYRO.get();
    private SampleProvider rate;
    private float[] sampleGyro;

    public GyroSensor() {
        rate = GYRO.getRateMode();
        sampleGyro = new float[rate.sampleSize()];
        GYRO.reset();
    }
    
    /*
     * ジャイロセンサから角速度を取得する。
     * @return 角速度
     */
    private final float getGyroValue() {
        rate.fetchSample(sampleGyro, 0);
        return -sampleGyro[0];
    }
}
