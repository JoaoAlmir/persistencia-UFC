import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1. Crie uma aplicação em Java que recebe via linha de comando: 
    a. O nome de um arquivo CSV; 
    b. O delimitador usado para separar os campos do arquivo; 
    c. Uma lista de nomes das colunas do arquivo CSV que serão processados. 
  Considere que o arquivo CSV:
    -> Deva ter um cabeçalho com os nomes das colunas em sua primeira linha e que não tenha internamente colunas com Strings contendo o mesmo caractere usado como delimitador 
    -> A aplicação deve exibir a soma e a média das colunas selecionadas caso tenham dados numéricos. 
    -> Se não tiverem dados numéricos, somente exibir que aquela coluna não é numérica. 
    -> Não usar bibliotecas externas para resolver esta questão (usar Java puro).
    -> Sugere-se navegar apenas uma única vez em cada linha do arquivo CSV. 
  Fazer a aplicação de modo que ela possa processar arquivos CSV extremamente grandes, mesmo que não caibam na memória RAM.
  Dica: usar o método split da classe String para separar os valores das colunas em cada linha do arquivo CSV. */
  
public class Ex1 {

    public static void main(String[] args) throws IOException {

        String regex = "[0-9]+";

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(args[1]);
                records.add(Arrays.asList(values));
            }
        }

        for (int i = 0; i < records.get(i).size(); i++) {
            double soma = 0;
            double media = 0;
            boolean digito = true;
            for (int j = 1; j < records.get(i).size()+1; j++) {
                
                if (!records.get(j).get(i).matches(regex)) {
                    if (!records.get(j).get(i).equals(""))
                        System.out.println("Coluna " + j + " não é numérica");
                    digito = false;
                    break;


                } else {
                    soma += Integer.parseInt(records.get(j).get(i));
                }
            }
            if (digito) {
                media = soma / records.get(i).size();
                System.out.println("===========");
                System.out.println("coluna " + (i+1));
                System.out.println("media: " + String.format("%.2f", media));
                System.out.println("soma: " + soma);
                System.out.println("===========");
            }

        }
    }
}
