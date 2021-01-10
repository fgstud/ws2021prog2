package sensordata;

import java.io.IOException;
import java.io.OutputStream;

public interface SensorDataSender {
    /**
     *
     * @param data collected data from a sensor
     * @param os stream the data will be send to
     */
    void sendSensorData(SensorData data, OutputStream os) throws IOException;
}
