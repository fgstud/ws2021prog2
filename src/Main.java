import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            String filename = "testFile.txt";
            OutputStream os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn't open file - fatal");
            System.exit(0); //Brutal exception handling

        }

        String someText = "Hallo";
        byte[] textAsByte = someText.getBytes();

        try {
            os.write(textAsByte);
        } catch (IOException exception) {
            System.err.println("couldn't write data (fatal)");
            System.exit(0);
        }

        
    }
}
