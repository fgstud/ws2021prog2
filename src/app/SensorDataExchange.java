package app;

import sensordata.SensorData;

import java.io.IOException;

public interface SensorDataExchange {
    /**
     * Send sensor data to a specified host
     * @param data
     * @param host
     * @param port
     */
    void sendSensorData(SensorData data, String host, int port) throws IOException;

    /**
     * Listen on a port and receive sensor data
     * @param data
     * @param port
     */
    void receiveSensorData(SensorData data, int port) throws IOException;
}
