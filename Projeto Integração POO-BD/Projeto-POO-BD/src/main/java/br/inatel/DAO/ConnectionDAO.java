package br.inatel.DAO;
import java.sql.*;
    public abstract class ConnectionDAO {
        Connection con; //conexão
        PreparedStatement pst; // declaração(query) preparada - código em sql
        Statement st; //declaração(query) - código em sql
        ResultSet rs; //resposta do banco
        String database = "projeto";//nome do BD
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        public void connectToDB() {
            try {
                con = DriverManager.getConnection(url, user, password);
            }
            catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
