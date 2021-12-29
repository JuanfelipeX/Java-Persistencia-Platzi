package Gatos_App;

import java.io.IOException;
import javax.swing.JOptionPane;
import Gatos_App.Modelo.Gatos;
import Gatos_App.Servicios.GatosServicios;

public class Inicio {

    public static void main(String[] args) throws IOException {
        int opcionMenu = -1;
        String[] botones = { "1. Ver Gatos", "2. Ver Favortios" , "3. Salir" };

        do {

            //menu principal
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menu Principal" ,
                    JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

                    //validacion de opcion seleccionada por usuario3
                    for (int i = 0; i < botones.length; i++) {
                        if (opcion.equals(botones[i])) {
                            opcionMenu = i;
                        }
                    }

                    switch (opcionMenu) { 
                        case 0:
                        GatosServicios.verGatos();
                        break;
                    case 1:
                        Gatos gatos = new Gatos();
                        GatosServicios.verFavoritos(gatos.getApiKey());
                    
                        default:
                            break;
                    }
            
        } while (opcionMenu != 1);
    }
    
}