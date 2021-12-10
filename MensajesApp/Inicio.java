package MensajesApp;
import java.util.Scanner;

public class Inicio {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        do {

            System.out.println("---------------------------------" + "\n" +
            "APLICACIONES DE MENSAJES DON PIPE :D" + "\n" + 
            "1. Crear mensaje " + "\n" +
            "2. Lista mensajes " + "\n" +
            "3. Editar mensaje " + "\n" +
            "4. Eliminar mensaje " + "\n" +
            "5. Salir " + "\n" +
            "Seleccione la opcion que desea: " + "\n");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;

                case 2:
                    MensajesService.listaMensaje();
                    break;

                case 3:
                    MensajesService.editarMensaje();
                    break;

                case 4:
                    MensajesService.borrarMensaje();
                    break;

                case 5:
                    System.out.println("bye... ");
                    System.exit(0);
                    break;
            
                default:
                    break;
            }
            
        } while (opcion != 5);


        /*
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.get_connection()){
            
        } catch (Exception e) {
            System.out.println(e);
        }
        */
        
    }
}
