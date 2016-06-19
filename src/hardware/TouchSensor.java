package hardware;

import lejos.hardware.sensor.EV3TouchSensor;

public class TouchSensor {
    private static final EV3TouchSensor TOUCH = (EV3TouchSensor) DeviceType.TOUCH.get();
    private final float SWITCH_ON = 1;
    private final float SWITCH_OFF = 0;
    
    public TouchSensor() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean isTouched(){
        float[] touchValue = new float[TOUCH.sampleSize()];
        TOUCH.fetchSample(touchValue, 0);
        return touchValue[0] == SWITCH_ON ? true : false;
    }
}
