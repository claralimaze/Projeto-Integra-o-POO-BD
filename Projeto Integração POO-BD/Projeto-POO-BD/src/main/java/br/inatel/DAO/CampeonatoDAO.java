package br.inatel.DAO;
import Model.Campeonato;
import java.sql.SQLException;

public class CampeonatoDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou
    public boolean insertCampeonato(Campeonato campeonato) { //função para inserir campeonatos na tabela
        connectToDB();
        String sql = "INSERT INTO campeonato (nome, prémios, região) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, campeonato.getNome());
            pst.setString(2, campeonato.getPremios());
            pst.setString(3, campeonato.getRegiao());
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
