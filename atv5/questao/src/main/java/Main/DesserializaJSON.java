package Main;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DesserializaJSON {
    public static void main(String[] args) throws Exception {

        File file = new File("./src/main/java/Main/jogos.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ListaJogo lj = objectMapper.readValue(file, ListaJogo.class);
        System.out.println(lj);

    }
}
