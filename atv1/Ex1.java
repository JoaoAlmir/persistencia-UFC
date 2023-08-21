import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex1{
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[0]);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine(); // primeira linha

        for (int i = 0; i < 10; i++) {
            System.out.println(s);
            s = br.readLine();
        }
        br.close();
    }
}