package persistencia.src.main.java.com.example;
public class Jogo implements java.io.Serializable{

    private int id;
    private String nome;
    private String categoria;
    private String descricao;
    private String desenvolvedora;
    private String distribuidora;
    private Double preco;
    private Double nota;

    
    public Jogo() {
    }

    public Jogo(int id, String nome, String categoria, String descricao, String desenvolvedora, String distribuidora, Double preco, Double nota) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.desenvolvedora = desenvolvedora;
        this.distribuidora = distribuidora;
        this.preco = preco;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Jogo{" + "id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", descricao=" + descricao + ", desenvolvedora=" + desenvolvedora + ", distribuidora=" + distribuidora + ", preco=" + preco + ", nota=" + nota + '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDesenvolvedora() {
        return this.desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDistribuidora() {
        return this.distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }


    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Double getNota() {
        return nota;
    }
    
    public void setNota(Double nota) {
        this.nota = nota;
    }
    
}
