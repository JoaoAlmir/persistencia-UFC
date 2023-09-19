package Main;
import java.io.File;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class DesserializaXML {
    public static void main(String[] args) throws Exception {

        File file = new File("./src/main/java/Main/jogos.xml");
        XmlMapper xmlMapper = new XmlMapper();
        ListaJogo lj = xmlMapper.readValue(file, ListaJogo.class);
        System.out.println(lj);

    }
}
