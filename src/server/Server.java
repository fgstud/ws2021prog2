package server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port;
    ServerSocket server = null;
    Socket socket = null;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            server = new ServerSocket(port);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        // Serversocket wird accept geschickt? (erneut abfragen was hier genau passiert...

        try {
            socket = server.accept();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }



        InputStream is = null; //Es wird ein Input Stream Initialisiert
        {
            try {
                is = socket.getInputStream(); //Inputstream erhät die Daten vom Socket
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        OutputStream os = null; //Es wird ein Output Stream initialisiert
        {
            try {
                os = socket.getOutputStream(); //Outputstream erhält die Daten vom Socket
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        PrintStream ps = new PrintStream(os);
        ps.println(":)");


        try {
            socket.getInputStream();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try {
            socket.close(); // Socket wird geschlossen. Ich habe noch nicht ganz verstanden warum, aber das kommt noch.
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}