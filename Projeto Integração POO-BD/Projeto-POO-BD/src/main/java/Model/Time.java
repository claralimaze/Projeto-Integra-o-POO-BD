package Model;
public class Time {
    private String nome;
    private String mascote;
    private int tecnicoCPF;

    public Time(String nome, String mascote, int tecnicoCPF) {
        this.nome = nome;
        this.mascote = mascote;
        this.tecnicoCPF = tecnicoCPF;
    }
    public String getNome() {
        return nome;
    }
    public String getMascote() {
        return mascote;
    }
    public int getTecnicoCPF() {
        return tecnicoCPF;
    }
}
