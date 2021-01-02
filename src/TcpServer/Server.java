package TcpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORTNUMBER = 3333;
    /**Schlachtplan:
     * 1- Konstruktor
     * 2- Main Methode in der klasse an sich
     * 3. Jar erzeugen **/


    private final int PORT; // PORT is the portnumber used for the Server
    private ServerSocket server; // The socket of the server
    Socket socket; // the socket

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(PORTNUMBER);
        server.openPort();
    }

    public Server(int port){
        this.PORT = port;
    }

    private void openPort() throws IOException, InterruptedException {
        ServerSocket srvSocket = new ServerSocket(this.PORT); // server socket created

        socket = srvSocket.accept(); // client connection accepted

        socket.getInputStream().read(); //read input stream from the socket

        OutputStream os = socket.getOutputStream(); // get the output stream of the socket
        os.write(":)".getBytes()); // convert :) into bytes and write that into the output stream
        Thread.sleep(5000); // the threat sleeps for a second
        os.close(); // the output stream is closed
    }
}