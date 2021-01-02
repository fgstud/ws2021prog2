package TcpClient;

import javax.print.DocFlavor;
import java.io.*;
import java.net.Socket;

public class Client {
    private static final String INPUTNAME = "localhost";
    private static final int INPUTPORT = 3333;
    private static final String SOMETHING = "something";
    private static final String ERRORMESSAGE_MISSING_HOSTNAME_PORTNUMBER = "Error: Hostname & portnumber missing";

    String name;
    int port;

    public Client(String inputName, int inputPort) throws IOException {
        this.name = inputName;
        this.port = INPUTPORT;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println(ERRORMESSAGE_MISSING_HOSTNAME_PORTNUMBER);
        }
        String hostname = args[0];
        String portnumberString = args[1];

        int portnumber = Integer.parseInt(portnumberString);

        Client client = new Client(hostname, portnumber);
        client.doShit();
    }

    private void doShit() throws IOException {

        Socket socket = new Socket(this.name, this.port);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write(SOMETHING.getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = 0;
        int read = 0; // the value that was read from the stream is saved here
        do {
            read = is.read(); // saving of the byte from the input stream
            if(read != -1) { // if the read byte is -1, the server is not sending anymore and the stream is finished (for now)
                baos.write(read);
                }
        } while (read != -1);

        System.out.println(baos.toString());;
    }

}
