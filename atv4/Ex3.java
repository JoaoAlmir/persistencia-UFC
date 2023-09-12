import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {

    public static void main(String[] args) throws IOException, InterruptedException {

        String command = "unzip -P "+ args[2] + " -d "+ args[1] + " " + args[0];
                        //unzip -P chave -d deszipado zipado.zip
        Process proc = Runtime.getRuntime().exec(command);

        // Read the output

        BufferedReader reader =  
              new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }

        proc.waitFor();   

    }
} 