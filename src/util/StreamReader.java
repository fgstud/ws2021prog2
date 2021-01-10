package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public interface StreamReader {
    void copyToStream(InputStream is, OutputStream outputStream);
    void copyToStream(FileInputStream fis, OutputStream outputStream);
}
