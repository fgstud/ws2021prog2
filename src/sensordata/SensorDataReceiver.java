package sensordata;

import java.io.IOException;
import java.io.InputStream;

public interface SensorDataReceiver {
    /**
     * receives data collected from a sensor
     * @param is stream from which the data will be read from
     * @return the data that was collected from a sensor
     */
    SensorData receiveSensorData(InputStream is) throws IOException;
}
