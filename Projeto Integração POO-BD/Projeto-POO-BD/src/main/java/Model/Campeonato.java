package Model;
public class Campeonato {
    String nome;
    String premios;
    String regiao;

    public Campeonato(String nome, String premios, String regiao) {
        this.nome = nome;
        this.premios = premios;
        this.regiao = regiao;
    }
    public String getNome() {
        return nome;
    }
    public String getPremios() {
        return premios;
    }
    public String getRegiao() {
        return regiao;
    }
}
