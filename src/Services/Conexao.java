//nome do pacote
package Services;

//importações
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author drink
 */
public class Conexao {

    private static Conexao instance = null;

    private static Connection createConnection() {
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "root");
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/singleton",
                    config
            );

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private Connection conn;

    private Conexao() {
        this.conn = Conexao.createConnection();
    }

    public static Conexao getInstance() {
        if (Conexao.instance == null) {
            Conexao.instance = new Conexao();
        }
        return Conexao.instance;
    }
    
    public Connection getConn() {
        return conn;
    }

}
