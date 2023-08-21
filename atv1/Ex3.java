import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[0]);
        InputStream is2 = new FileInputStream(args[1]);
        InputStreamReader isr = new InputStreamReader(is);
        InputStreamReader isr2 = new InputStreamReader(is2);
        BufferedReader br = new BufferedReader(isr);
        BufferedReader br2 = new BufferedReader(isr2);
        
        String s = br.readLine();
        String s2 = br2.readLine();


        while (s != null) {
            System.out.println(s);
            s = br.readLine();
        }
        br.close();

        while (s2 != null) {
            System.out.println(s2);
            s2 = br2.readLine();
        }
        br2.close();
    }
}