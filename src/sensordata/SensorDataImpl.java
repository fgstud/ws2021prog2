package sensordata;

class SensorDataImpl implements SensorData{

    private final long timeStamp;
    private final float value;
    private final String sensorname;

    public SensorDataImpl(long timeStamp, float value, String sensorName) {
        this.timeStamp = timeStamp;
        this.value = value;
        this.sensorname = sensorName;
    }

    @Override
    public long getTimeStamp() {
        return 0;
    }

    @Override
    public float getValue() {
        return 0;
    }

    @Override
    public String getSensorName() {
        return null;
    }
}
