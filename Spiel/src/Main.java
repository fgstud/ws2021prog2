import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String filename = "testFile.txt";

        try {

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

        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        a
    }
}
