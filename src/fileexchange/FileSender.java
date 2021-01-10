package fileexchange;

import java.io.IOException;
import java.io.OutputStream;

public interface FileSender {
    /**
     * send file from a local programn over an output stream to maybe another process
     * @param filename local filename
     * @param os connection / stream to remote entity
     */

    void sendFile(String filename, OutputStream os) throws IOException;


}
