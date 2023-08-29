import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Ex3 {
    public static void main(String[] args) {

        try {

            InputStream is = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();

            PrintStream ps = new PrintStream(args[1]);

            while (s != null) {
                try {
                    s = new String(s.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    System.out.println("Erro na conversão de encoding");
                }
                ps.println(s);
                s = br.readLine();
            }
            ps.close();
            br.close();

        } catch (IOException e) {
            System.out.println("Erro na entrada ou saida");
        }

    }
}