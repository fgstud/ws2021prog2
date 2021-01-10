package util;


import app.TCPFileExchange;
import app.TCPFileExchangeImpl;

import java.io.IOException;

/**
 * UI for filetransfer
 * expected parameters
 * 1) send: file name, hostname (recipient), port
 * 2) receive: filename, port
 */
public class TCPfileExchangerUI {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 2) {
            System.err.println("At least two arguments required");
        }
        String filename = args[0];
        String hostname = null;
        int port = -1;
        String portString = null;

        if (args.length == 3) { //var 1 send
            hostname = args[1];
            portString = args[2];
        } else if (args.length == 2) { // var 2 receive
            portString = args[1];
        }
        port = Integer.parseInt(portString);

        TCPFileExchange tcpFileExchanger = new TCPFileExchangeImpl();

        if (hostname == null) {
            //receive
            tcpFileExchanger.receiveFile(filename, port);
        } else {
            //send
            tcpFileExchanger.sendFileToHost(filename, hostname, port);
        }

    }
}
