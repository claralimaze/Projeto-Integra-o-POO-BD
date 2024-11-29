package br.inatel.DAO;
import Model.Tecnico;
import java.sql.SQLException;

public class TecnicoDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou

    //insert (Crud)
    public boolean insertTecnico(Tecnico tecnico) { //função para inserir tecnicos na tabela
        connectToDB();
        String sql = "INSERT INTO técnico (CPF, nome, idade, títulos) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, tecnico.getCpf());
            pst.setString(2, tecnico.getNome());
            pst.setInt(3, tecnico.getIdade());
            pst.setInt(4, tecnico.getTitulos());
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
