package Main;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "listaJogos")
public class ListaJogo implements java.io.Serializable {
    
    @JacksonXmlElementWrapper(localName = "jogos")
    @JacksonXmlProperty(localName = "jogo")
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
