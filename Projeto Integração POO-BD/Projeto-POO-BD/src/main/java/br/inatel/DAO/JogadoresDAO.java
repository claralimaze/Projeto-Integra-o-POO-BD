package br.inatel.DAO;
import Model.Jogadores;
import java.sql.SQLException;
import java.util.ArrayList;

public class JogadoresDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou

    //insert (Crud)
    public boolean insertJogadores(Jogadores jogadores) { //função para inserir jogadores na tabela
        connectToDB();
        String sql = "INSERT INTO jogadores (CPF, nome, altura, peso, n_da_camisa, time_nome) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, jogadores.getCpf());
            pst.setString(2, jogadores.getNome());
            pst.setInt(3, jogadores.getAltura());
            pst.setInt(4, jogadores.getPeso());
            pst.setInt(5, jogadores.getNumeroCamisa());
            pst.setString(6, jogadores.getTimeNome());
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

    // select (cRud)
    public ArrayList<Jogadores> selectJogadores() { // seleciona os jogadores com mais de 1.70
        ArrayList<Jogadores> jogadores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM jogadores where altura > 170";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de jogadores com mais de 1.70: ");
            while (rs.next()) {
                Jogadores jogadoresAux = new Jogadores(rs.getInt("cpf"), rs.getString("nome"), rs.getInt("altura"), rs.getInt("peso"), rs.getInt("n_da_camisa"), rs.getString("time_nome"));
                System.out.println("cpf = " + jogadoresAux.getCpf());
                System.out.println("nome = " + jogadoresAux.getNome());
                System.out.println("altura = " + jogadoresAux.getAltura());
                System.out.println("peso = " + jogadoresAux.getPeso());
                System.out.println("numeroCamisa = " + jogadoresAux.getNumeroCamisa());
                System.out.println("--------------------------------");
                jogadores.add(jogadoresAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } return jogadores;
    }

    //update (crUd)
    public boolean updateJogadoresNumeroCamisa(int cpf, int numeroCamisa) {
        connectToDB();
        String sql = "UPDATE jogadores SET n_da_camisa=? where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, numeroCamisa);
            pst.setInt(2, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //delete (cruD)
    public boolean deleteJogadores(int cpf) {
        connectToDB();
        String sql = "DELETE FROM jogadores where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}
