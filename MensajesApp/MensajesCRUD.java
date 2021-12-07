package MensajesApp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MensajesCRUD {

    public static void crearMensajeBD(Mensajes mensajes) {
        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje, fecha_mensaje) VALUES (?, ?, CURRENT_TIMESTAMP);";  
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setString(2, mensajes.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");

            } catch (Exception e) {
                System.out.println("Mensaje no creado " + e);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public static void leerMensajeBD() {

    }

    public static void borrarMensajeBD(int idMensaje) {

    }
    
    public static void actualizarMensajeBD(Mensajes mensajes) {
        
    }
    
}
