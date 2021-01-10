package sensordata;

public interface SensorData {

    /**
     *
     * @return return time stamp of measurement
     */
    long getTimeStamp();

    /**
     *
     * @return value measures by a sensor
     */
    float getValue();

    /**
     *
     * @return name of a sensor
     */
    String getSensorName();
}
