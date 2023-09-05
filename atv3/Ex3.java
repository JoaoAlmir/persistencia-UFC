import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/*3. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

  -> arquivo config.properties
      - arquivo = meu_arquivo.txt
      - linha_inicial = 1
      - linha_final = 3
  -> Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties. */

  public class Ex3 {
    public static void main(String[] args) throws IOException {
        String arquivo = "";
        Integer linha_inicial = 0;
        Integer linha_final = 0;

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
            arquivo = prop.getProperty("arquivo");
            linha_inicial = Integer.parseInt(prop.getProperty("linha_inicial"));
            linha_final = Integer.parseInt(prop.getProperty("linha_final"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        InputStream is = new FileInputStream(arquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine(); // primeira linha

        for (int i = 0; i < linha_inicial-1; i++) {
            s = br.readLine();
        }

        for (int i = linha_inicial-1; i < linha_final; i++) {
            System.out.println(s);
            s = br.readLine();
        }
        br.close();

    }

}
