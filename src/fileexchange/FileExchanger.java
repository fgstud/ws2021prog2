package fileexchange;

import java.io.*;

public class FileExchanger implements FileSender, FileReceiver {

    @Override
    public void sendFile(String filename, OutputStream os) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        StreamData(fis, os);
        os.close();
    }

    @Override
    public void receiveFile(String filename, InputStream is) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        StreamData(is, fos);
    }

    private void StreamData(InputStream is, OutputStream os) throws IOException {
        int read = 0;
        do {
            read = is.read();
            if (read != -1) {
                os.write(read);
            }
        } while (read != -1);
    }
}