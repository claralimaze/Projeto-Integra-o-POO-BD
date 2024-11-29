package br.inatel.DAO;
import Model.Tecnico;
import Model.Time;
import java.sql.SQLException;
public class TimeDAO extends ConnectionDAO {
    boolean sucesso = false; //Para saber se funcionou

    public boolean insertTime(Time time) { //função para inserir times na tabela
        connectToDB();
        String sql = "INSERT INTO time (nome, mascote, técnico_CPF) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, time.getNome());
            pst.setString(2, time.getMascote());
            pst.setInt(3, time.getTecnicoCPF());
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
