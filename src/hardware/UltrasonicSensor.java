package hardware;

import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class UltrasonicSensor {
    private static final EV3UltrasonicSensor ULTRASONIC = (EV3UltrasonicSensor) DeviceType.ULTRASONIC.get();
    SampleProvider distanceMode;
    private float[] sampleDistance;
    private static final float SONAR_ALERT_DISTANCE = 0.3F; // 超音波センサーによる障害物検知距離[m]

    public UltrasonicSensor() {
        distanceMode = ULTRASONIC.getDistanceMode();
        sampleDistance = new float[distanceMode.sampleSize()];
    }

    /*
     * 超音波センサーによる障害物検知
     * @return true(障害物あり)/false(障害物無し)
     */
    private boolean alertObstacle() {
        float distance = getSonarDistance();
        if ((distance <= SONAR_ALERT_DISTANCE) && (distance >= 0)) {
            return true; // 障害物を検知
        }
        return false;
    }

    /*
     * 超音波センサーにより障害物との距離を取得する。
     * @return 障害物との距離(m)。
     */
    private final float getSonarDistance() {
        distanceMode.fetchSample(sampleDistance, 0);
        return sampleDistance[0];
    }
}
