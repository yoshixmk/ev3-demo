package linetrace;

public class PID {
    private static float[] diff;
    private static float integral;
    private float kp;
    private float ki;
    private float kd;
    // 計測結果から、msオーダー以下の非常に小さい値。100usとした
    private final float deltaT = 0.0001F;

    public PID() {
        diff = new float[2];
    }

    public float pid(float sensorVal, float targetVal) {
        float p, i, d;
        diff[0] = diff[1];
        diff[1] = sensorVal - targetVal;
        integral += (diff[1] + diff[0]) / 2.0 * deltaT;
        p = kp * diff[1];
        i = ki * integral;
        d = kd * (diff[1] - diff[0]) / deltaT;
        return limitRange(p + i + d);
    }

    private float limitRange(float value) {
        final float MAX = 100.0F;
        final float MIN = -100.0F;
        float limitedValue = value;
        if (MAX < value) {
            limitedValue = MAX;
        } else if (MIN > value) {
            limitedValue = MIN;
        }
        return limitedValue;
    }

    public float getKp() {
        return kp;
    }

    public PID setKp(float kp) {
        this.kp = kp;
        return this;
    }

    public float getKi() {
        return ki;
    }

    public PID setKi(float ki) {
        this.ki = ki;
        return this;
    }

    public float getKd() {
        return kd;
    }

    public PID setKd(float kd) {
        this.kd = kd;
        return this;
    }
}
