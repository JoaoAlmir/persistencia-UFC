import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo compactado a ser criado e (2) uma pasta. Compactar todos os arquivos e subpastas em um arquivo compactado com extensão zip.

public class Ex1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        String command = "zip -r "+ args[1] + " " + args[0];

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