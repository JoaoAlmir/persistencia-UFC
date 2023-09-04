import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex1 {
    public static void main(String[] args) {
        try {
            long ini = System.currentTimeMillis();

            byte[] bytes = Files.readAllBytes(Paths.get(args[0]));
            FileOutputStream is = new FileOutputStream(args[1]);
            
            is.write(bytes);
            
            long fim = System.currentTimeMillis();

            System.out.println("Tempo de execução: " + (fim - ini) + " ms");

            is.close();
        } catch (IOException e) {
            System.err.println("Erro na entrada ou saida");
        }
    }
}