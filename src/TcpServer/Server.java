package TcpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORTNUMBER = 3333;
    /**Schlachtplan:
     Der Stream braucht ein Stop-symbol ";"
     Vor dem Symbol: Name
     Nach dem Symbol: Datei

      **/


    private final int PORT; // PORT is the portnumber used for the Server
    private ServerSocket server; // The socket of the server
    Socket socket; // the socket
    private String filename=null;

    public Server(int port){
        this.PORT = port;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(PORTNUMBER);
        if (args.length != 0) {
            String filename = args[0];
            server.getFile(filename);
        } else {
            server.doShit();
        }
    }

    private void getFile(String filename) throws IOException {
        Socket socket = acceptSocket(PORT);
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(filename);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        char charRead;
        String filenameInput;
        int read = 0;
        do {
            read = is.read();

            if (read != -1) {
                do {
                    if ((char) read != ';') {
                        baos.write(read);
                    }
                } while ((char) read != ';');

                FileOutputStream fosInputname = new FileOutputStream(baos.toString() + ".txt");
                fosInputname.write(read);

                fos.write(read);
            }

        } while (read != -1);
    }

    private Socket acceptSocket(int port) throws IOException {
        return new ServerSocket(port).accept();
    }


    private void doShit() throws IOException, InterruptedException {

        socket = acceptSocket(this.PORT); // client connection accepted

        socket.getInputStream().read(); //read input stream from the socket

        OutputStream os = socket.getOutputStream(); // get the output stream of the socket
        os.write(":)".getBytes()); // convert :) into bytes and write that into the output stream
        Thread.sleep(5000); // the threat sleeps for a second
        os.close(); // the output stream is closed
    }
}