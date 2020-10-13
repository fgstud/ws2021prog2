package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {



    String name = "localhost";
    int port = 3333;
    Socket socket;

    {
        try {
            socket = new Socket(name, port);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    InputStream is;
    {
        try {
            is = socket.getInputStream();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    OutputStream os;
    {
        try {
            os = socket.getOutputStream();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }



}
