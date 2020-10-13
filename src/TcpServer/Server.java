package TcpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port = 3333;
    ServerSocket server;
    Socket socket;


    {
        try {
            server = new ServerSocket(port);
            socket = server.accept();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
