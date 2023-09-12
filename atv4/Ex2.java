import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser encriptado, (2) o nome do arquivo encriptado a ser criado e (3) a chave de encriptação.
public class Ex2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        String command = "zip -e -r -P "+ args[2] + " "+ args[1] + " " + args[0];
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