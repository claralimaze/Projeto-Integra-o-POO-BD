package br.inatel.DAO;
import Model.TimeHasCampeonato;
import java.sql.SQLException;

public class TimeCampDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou
    public boolean insertTimeCamp(TimeHasCampeonato timeCamp) { //função para inserir campeonatos na tabela
        connectToDB();
        String sql = "INSERT INTO time_has_campeonato (time_nome, campeonato_nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, timeCamp.getNomeTime());
            pst.setString(2, timeCamp.getNomeCampeonato());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        } return sucesso;
    }
}
