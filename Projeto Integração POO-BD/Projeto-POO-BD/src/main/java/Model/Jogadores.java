package Model;
public class Jogadores {

    private int cpf;
    private String nome;
    private int altura;
    private int peso;
    private int numeroCamisa;
    private String timeNome;

    public Jogadores(int cpf, String nome, int altura, int peso, int numeroCamisa, String timeNome) {
        this.cpf = cpf;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.numeroCamisa = numeroCamisa;
        this.timeNome = timeNome;
    }
    public int getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public int getAltura() {
        return altura;
    }
    public int getPeso() {
        return peso;
    }
    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public String getTimeNome() {
        return timeNome;
    }
}
