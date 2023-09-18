import java.util.List;

public class ListaJogo {
    private List<Jogo> jogos;

    public ListaJogo(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    @Override
    public String toString() {
        return "ListaJogo{" + "jogos=" + jogos + '}';
    }

    public List<Jogo> getJogos() {
        return this.jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

}
