import server.Client;
import server.Server;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Server server = new Server(3333);
        server.start();
    }
}
