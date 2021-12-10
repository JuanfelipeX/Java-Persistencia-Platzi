package MensajesApp;

import java.util.Scanner;

public class MensajesService {

    static Scanner sc = new Scanner(System.in);

    public static void crearMensaje() {
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Escribe tu nombre: ");
        String autorMensaje = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(autorMensaje);

        MensajesCRUD.crearMensajeBD(registro);
    }
    
    public static void listaMensaje() {
        MensajesCRUD.leerMensajeBD();

    }
    
    public static void borrarMensaje() {
        System.out.println("Escriba el id del mensaje: ");
        int idMensaje = Integer.parseInt(sc.nextLine());

        MensajesCRUD.borrarMensajeBD(idMensaje);

    }
    
    public static void editarMensaje() {
        System.out.println("Escriba el id del mensaje:");
        int idMensaje = Integer.parseInt(sc.nextLine());

        System.out.println("Escribe el nuevo mensaje: ");
        String mensaje = sc.nextLine();

        Mensajes actualizar = new Mensajes();
        actualizar.setIdMensaje(idMensaje);
        actualizar.setMensaje(mensaje);

        MensajesCRUD.actualizarMensajeBD(actualizar);
    }
}
