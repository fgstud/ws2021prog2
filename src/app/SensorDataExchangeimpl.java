package app;

import sensordata.SensorData;
import sensordata.SensorDataExchanger;
import sensordata.SensorDataReceiver;
import sensordata.SensorDataSender;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;

public class SensorDataExchangeimpl implements SensorDataExchange{


    @Override
    public void sendSensorData(SensorData data, String host, int port) throws IOException {
        //establish connection
        Client client = new TCPConnector();
        Connection connection = client.connect(host, port);

        //send data
        SensorDataSender sender = new SensorDataExchanger();
        sender.sendSensorData(data, connection.getOutputStream());
    }

    @Override
    public void receiveSensorData(SensorData data, int port) throws IOException {
        // establish connection
        Server server = new TCPConnector();
        Connection connection = server.acceptConnection(port);

        // receive data
        SensorDataReceiver receiver = new SensorDataExchanger();
        receiver.receiveSensorData(connection.getInputStream());
    }
}
