package MensajesApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection() {
       
        Connection singletonConn = null;

        if (singletonConn == null) {
            try {

                String host = "jdbc:mysql://localhost:3306/mensajes_app";
                String uName = "root";
                String uPass = "1234";

                singletonConn = DriverManager.getConnection(host, uName, uPass);

                 //if (singletonConn != null) {
                 //    System.out.printf("Successfully connected to the db...\n");
                 //}
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return singletonConn;
    }
}
        
    