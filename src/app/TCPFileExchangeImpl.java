package app;

import fileexchange.FileExchanger;
import fileexchange.FileReceiver;
import fileexchange.FileSender;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;

public class TCPFileExchangeImpl implements TCPFileExchange {

    @Override
    public void sendFileToHost(String filename, String host, int port) throws IOException {
        // need connection
        Client client =new TCPConnector();
        Connection connection = client.connect(host, port);
        // send file
        FileSender fileSender = new FileExchanger();
        fileSender.sendFile(filename, connection.getOutputStream());
    }

    @Override
    public void receiveFile(String filename, int port) throws IOException {
        // need server
        Server server = new TCPConnector();
        Connection connection =server.acceptConnection(port);

        FileReceiver fileReceiver = new FileExchanger();
        fileReceiver.receiveFile(filename, connection.getInputStream());
    }
}
