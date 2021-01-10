package tcp;

import java.io.IOException;

public interface Server {
    /**
     * opens a port and waits for a connection from a client
     * @param port number of the port that will be opened
     * @return the established connection
     */
    Connection acceptConnection(int port) throws IOException;
}
