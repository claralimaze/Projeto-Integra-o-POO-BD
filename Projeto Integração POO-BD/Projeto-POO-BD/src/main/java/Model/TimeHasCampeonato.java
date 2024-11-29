package Model;
public class TimeHasCampeonato {
    private  String nomeTime;
    private  String nomeCampeonato;

    public TimeHasCampeonato(String nomeTime, String nomeCampeonato) {
        this.nomeTime = nomeTime;
        this.nomeCampeonato = nomeCampeonato;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getNomeCampeonato() {
        return nomeCampeonato;
    }
}
