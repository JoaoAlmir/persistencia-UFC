package Main;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializaJava {
    public static void main(String[] args) {
        Jogo j1 = new Jogo(1, "Pac Man", "Ação", "come come", "Harry potter", "Hanna Montana", 100.0, 3.0);
        Jogo j2 = new Jogo(2, "Pou", "Sobrevivencia", "come come", "Silvio Santos", "Google", 0.0, 8.0);
        Jogo j3 = new Jogo(2, "Rift", "MMO", "farmaa", "Thor", "UFC", 0.0, 8.0);

        ListaJogo lj = new ListaJogo(List.of(j1, j2, j3));

        try {
            FileOutputStream fileOut = new FileOutputStream("./src/main/java/Main/jogos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lj);
            out.close();
            fileOut.close();
            System.out.printf("Serializado");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

}
