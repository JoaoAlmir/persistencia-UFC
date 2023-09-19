package Main;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializaXML {
    public static void main(String[] args) throws Exception {
        Jogo j1 = new Jogo(1, "Pac Man", "Ação", "come come", "Harry potter", "Hanna Montana", 100.0, 3.0);
        Jogo j2 = new Jogo(2, "Pou", "Sobrevivencia", "come come", "Silvio Santos", "Google", 0.0, 8.0);
        Jogo j3 = new Jogo(2, "Rift", "MMO", "farmaa", "Thor", "UFC", 0.0, 8.0);

        ListaJogo lj = new ListaJogo(List.of(j1, j2, j3));

        File f = new File("./src/main/java/Main/jogos.xml");
        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(f, lj);
    }
}
