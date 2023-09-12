import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//3. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser decriptado e (2) o nome do arquivo resultante da decriptação e (3) a chave de decriptação.
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