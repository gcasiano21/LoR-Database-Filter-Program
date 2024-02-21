/**
 * Class responsible for creating a connection to mySQL "final_project" database
 *
 * @author (Namson Nguyen and Giovanni Casiano)
 * @version (Version 1, Nov.20.2022)
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLJDBCUtil {
    /**  Get database connection * * @return a Connection object * @throws SQLException     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
         try {
            // db parameters use your schema and password
            String url       = "jdbc:mysql://127.0.0.1:3307/final_project";
            String user      = "root";
            String password  = "Tenpuha1banda";
        
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...    
        } catch(SQLException e) {
               System.out.println(e.getMessage());
            }
        return conn; 
    }
}    
