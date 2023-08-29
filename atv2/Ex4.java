import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        String texto = "";
        String linha = "";

        try {

            Scanner scan = new Scanner(System.in);
            linha = scan.nextLine();

            while (!(linha.equals("FIM"))) {
                texto += linha + "\n";
                linha = scan.nextLine();
            }

            System.out.println("Digite o nome do arquivo: ");
            linha = scan.nextLine();

            PrintStream ps = new PrintStream(linha);
            ps.println(texto);
            ps.close();
            scan.close();


        } catch (IOException e) {
            System.out.println("Erro na entrada ou saida");
        }

    }
}