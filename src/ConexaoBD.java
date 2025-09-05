import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/epostgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Marcelo1905";

    public static Connection getConecxao() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static ConexaoBD conexaoBD = null;
    public static ConexaoBD obterInstancia(){
        if(conexaoBD == null){
            conexaoBD = new ConexaoBD();
        }

        return conexaoBD;
    }

    public ResultSet consultar(String sql){
        try {
            PreparedStatement smt = getConecxao().prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            return  rs;
        } catch (SQLException e) {
            System.out.println("Problema Dao SQL - consultar.");
            System.out.println(e.toString());
        }
        return null;
    }

    public boolean iserir(String sql){
        try {
            PreparedStatement smt = getConecxao().prepareStatement(sql);
            smt.executeUpdate();
            smt.close();
        } catch (SQLException e) {
            System.out.println("Problema Dao SQL - inserir.");
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    public boolean excluir(String sql){
        try {
            PreparedStatement smt = getConecxao().prepareStatement(sql);
            smt.executeUpdate();
            smt.close();
        } catch (SQLException e) {
            System.out.println("Problema Dao SQL - excluir.");
            System.out.println((e.toString()));
            return false;
        }
        return true;
    }

    public boolean atualizar(String sql){
        try{
            PreparedStatement smt = getConecxao().prepareStatement(sql);
            smt.executeUpdate();
            smt.close();
        } catch (SQLException e){
            System.out.println("Problema Dao SQL - excluir.");
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
}
