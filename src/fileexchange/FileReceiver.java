package fileexchange;

import java.io.IOException;
import java.io.InputStream;

public interface FileReceiver {
    /**
     * Receives content from an input stream and writes it to a local file
     * @param filename local file name
     * @param is content provider
     */
    void receiveFile(String filename, InputStream is) throws IOException;

}
