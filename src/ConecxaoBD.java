import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConecxaoBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/epostgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Marcelo1905";

    public static Connection getConecxao() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
