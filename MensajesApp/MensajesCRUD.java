package MensajesApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Result;

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
                System.out.println("Mensaje creado correctamente :D");

            } catch (Exception e) {
                System.out.println("Mensaje no creado :c" + e);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void leerMensajeBD() {
        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id_mensaje") + "\n" + 
                "Mensaje: " + rs.getString("mensaje") + "\n" +
                "Autor: " + rs.getString("autor_mensaje") + "\n" +
                "Fecha: " + rs.getString("fecha_mensaje") + "\n");
            }

        } catch (Exception e) {
            System.out.println("No se pudo obtener los menesajes :c" + "\n" + e);
        }
    }

    public static void borrarMensajeBD(int idMensaje) {
        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";  
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");

            } catch (Exception e) {
                System.out.println("No se pudo borrar el mensaje :c" + e);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
            

    }
    
    public static void actualizarMensajeBD(Mensajes mensajes) {
        
    }
    
}
