package Main;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DesserializaJava {
    public static void main(String[] args) {
        ListaJogo lj = null;
        try {
            FileInputStream fileIn = new FileInputStream("./src/main/java/Main/jogos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            lj = (ListaJogo) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(lj);
    }
}