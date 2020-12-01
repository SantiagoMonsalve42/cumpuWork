package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Arcos
 */
public class ConexionMsql {
    
    public static ConexionMsql instance;//Singleton
    private Connection cnn;

    private ConexionMsql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//driver
            try {
                cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/extension_ud?autoReconnect=true&useSSL=false","root","123456");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionMsql.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionMsql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized ConexionMsql getInstance() { //synchronized para acceso sincronizado
        if (instance == null) {
            instance = new ConexionMsql();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion(){
    instance=null;
    }
}//fin clase
