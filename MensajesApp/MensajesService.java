package MensajesApp;

import java.util.Scanner;

public class MensajesService {

    static Scanner sc = new Scanner(System.in);

    public static void crearMensaje() {
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Escribe tu nombre");
        String autorMensaje = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(autorMensaje);

        MensajesCRUD.crearMensajeBD(registro);
    }
    
    public static void listaMensaje() {

    }
    
    public static void borrarMensaje() {

    }
    
    public static void editarMensaje() {
        
    }
    
}
