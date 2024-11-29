package Model;
public class Tecnico {
    private int cpf;
    private String nome;
    private int idade;
    private int titulos;

    public Tecnico(int cpf, String nome, int idade, int titulos){
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.titulos = titulos;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getTitulos() {
        return titulos;
    }
}
