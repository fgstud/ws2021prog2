package util;

import TcpClient.Client;
import TcpServer.Server;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length >= 2) {
            Client.main(args);
        }
        Server.main(args);
    }
}
