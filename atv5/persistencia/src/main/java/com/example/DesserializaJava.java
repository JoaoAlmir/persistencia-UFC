package persistencia.src.main.java.com.example;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DesserializaJava {
    public static void main(String[] args) {
        ListaJogo lj = null;
        try {
            FileInputStream fileIn = new FileInputStream("./jogo.ser");
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