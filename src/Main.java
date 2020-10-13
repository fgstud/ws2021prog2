import TcpServer.Client;
import TcpServer.Server;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*3.1  Schreiben in eine FileDerFileOutputStreamwird genutzt, um Daten in ein File zu schreiben.
        Schauen wir uns an, wie man einen solchen Stream öffnet:*/

        String filename = "testFile.txt"; //Aus dem try catch block entfernt. Keine Ahnung mehr warum
        OutputStream os = null; //aus dem try catch block entfernt, da die IDE gemeckert hat...

        try {
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn't open file - fatal");
            System.exit(0); //Brutal exception handling

        }


        /* Nun schreiben wir Daten. */
        String someText = "Hallo";
        byte[] textAsByte = someText.getBytes();

        try {
            os.write(textAsByte);
        } catch (IOException exception) {
            System.err.println("couldn't write data (fatal)");
            System.exit(0);
        }


        /* 3.2  Lesen aus einem File
        Das Lesen aus einem File ist ähnlich wenig aufregend. Wir benoetigen einen InputStream.
        Bei dessen Erzeugung koennen aus den gleichen Gruenden wie weiter oben Fehler entstehen.
        Die Fehlerbehandlung ist genauso brutal wie oben. */

        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("couldn't open file - fatal");
            System.exit(0);
        }

        /* Nun lesen wir aus dem Stream */

        byte[] readBuffer = new byte[100];
        try {
            is.read(readBuffer);
        } catch (IOException exception) {
            System.err.println("couldn't read data (fatal)");
            System.exit(0);
        }

        String readString = new String(readBuffer);
        System.out.println("read something: " + readBuffer);

        DataOutputStream dos = new DataOutputStream(os);

        try {
            dos.writeInt(42);
        } catch (IOException exception) {
            System.err.println("couldn't write Data (fatal");
            System.exit(0);
        }


        DataInputStream dis = new DataInputStream(is);

        try {
            int readIntValue = dis.readInt();
            
            System.out.println("read Integer: " + readIntValue);
        } catch (IOException exception) {
            System.err.println("couldn't read data (fatal)");
            System.exit(0);
        }


        PrintStream ps = new PrintStream(os);
        ps.println("Hello Stream");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);


        try {
            readString = br.readLine();
            System.out.println("las: " + readString);
        } catch (IOException er) {
            System.err.println("Nichts gelesen");
            System.exit(0);
        }


        Server server = new Server();
        Client client = new Client();


    }
}
