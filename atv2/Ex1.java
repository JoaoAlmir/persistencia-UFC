import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Ex1{
    public static void main(String[] args) throws FileNotFoundException,IOException {
        InputStream is = new FileInputStream(args[0]);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        PrintStream ps = new PrintStream(args[1]);

        while (s != null) {
            ps.println(s);
            s = br.readLine();
        }
        ps.close();
        br.close();
        



    }
}