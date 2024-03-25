package Config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.*;

/**
 *
 * Año 2024
 * 
 * @author Jhonatan Samuel Martinez Hernandez 
 * ficha 2675859 
 * 
 * Evidencia de desempeño:
 * 
 * Codificación de módulos del software según requerimientos del proyecto GA7-220501096-AA2-EV01
*
 * análisis y desarrollo de software 
 * 
 */
public class Connector {

    private String db = "clientManagerSystem";
    private String url = "jdbc:mariadb://localhost:3306/" + db;
    private String userName = "root";
    private String password = "";
    private String jdbcDriver = "org.mariadb.jdbc.Driver";
    Connection conn = null;

    // Starts the connection to the data base and return it
    public Connection start() {
        try {
            System.out.println("Connection successfully started");
            Class.forName(jdbcDriver);
            conn = (Connection) DriverManager.getConnection(url, userName, password);

        } catch (ClassNotFoundException ex) {
            System.out.println("There was an error with the connection");

            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("There was an error with the connection");

            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    // Close the connection to the database
    public void close() {
        try {
            conn.close();
                        System.out.println("Connection has been close successfully......");

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        Connector c = new Connector();
        c.start();
        c.close();

    }

}

/**
 *
 * Año 2024
 * 
 * @author Jhonatan Samuel Martinez Hernandez 
 * ficha 2675859 
 * 
 * Evidencia de desempeño:
 * 
 * Codificación de módulos del software según requerimientos del proyecto GA7-220501096-AA2-EV01
*
 * análisis y desarrollo de software 
 * 
 */