package app;

import java.io.IOException;

public interface TCPFileExchange {
    /**
     * send a file to the from local entitz to remote host via tcp
     * @param filename
     * @param host
     * @param port
     */
    void sendFileToHost(String filename, String host, int port) throws IOException;

    /**
     * Receive conten from a TCP client and write it to a local file
     * @param filename
     * @param port
     */
    void receiveFile(String filename, int port) throws IOException;
}
