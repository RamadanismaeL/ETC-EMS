/**
 * @author Ramadan ismaeL
 */

package englishtraingcenter.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    static Connection conexao;
    private final String url = "jdbc:sqlite:dbetc.db";

    @SuppressWarnings("exports")
    public Connection connectDAO() {
        try {
            conexao = DriverManager.getConnection(url);
            System.out.println("Conectado!");
            return conexao;
        } catch(SQLException error) {
            error.printStackTrace();
        } catch(Exception error) {
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            error.printStackTrace();
        }
        return null;
    }
}
