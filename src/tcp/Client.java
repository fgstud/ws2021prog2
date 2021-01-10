package tcp;

import java.io.IOException;

public interface Client {
    /**
     * establishes a connection to a server
     * @param hostname hostname of the server of which a connection shall be established
     * @param port number of the port on which the host is waiting for a connection
     * @return
     */
    Connection connect(String hostname, int port) throws IOException;
}
