package Servicios;

import com.google.gson.Gson;
import Modelo.Gatos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GatosServicios {
    
    //RECORDAR QUE DEBEMOS DESCARGAR LOS ARCHIVOS JAR DE MYSQLCONNECTION, GSON Y OKHHTP 
    //PARA QUE FUNCIONE LA API Y CONFIGURARLOS E IMPORTALOS EN UN JSON
    
    // https://github.com/santiaguf/gatos_app/blob/master/src/main/java/com/platzi/gatos_app/service/CatService.java
    //REPOSITORIO DEL PROFESOR

    private static String BASE_URL = "https://api.thecatapi.com/v1/";
    private static String SEARCH_ENDPOINT = BASE_URL + "images/search";
    private static String FAVORITE_ENDPOINT = BASE_URL + "favourites";
    private static String FavoriteMenu = "Opciones: \n"
            + " 1. ver otra imagen \n"
            + " 2. Eliminar Favorito \n"
            + " 3. Volver \n";

    private static String menuGatosAleatorio = "Opciones: \n"
            + " 1. ver otra imagen \n"
            + " 2. Favorito \n"
            + " 3. Volver \n";


    public static void verGatos() throws IOException {

        //trayendo datos de la api, 
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();

        Response response = client.newCall(request).execute();
        String jsonDatos = response.body().string();

        //corta los corchetes del postman
        jsonDatos = jsonDatos.substring(1, jsonDatos.length());
        jsonDatos = jsonDatos.substring(0, jsonDatos.length() - 1);

        //crea el objeto de la clase GSON
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(jsonDatos, Gatos.class);

        //redimensionar la imagen
        Image imagen = null;

        try {
            URL url = new URL(gatos.getUrl());
            imagen = ImageIO.read(url);

            ImageIcon imagenGato = new ImageIcon(imagen);

            if (imagenGato.getIconWidth() > 800) {

                //redimensiona
                Image fondo = imagenGato.getImage();
                Image modificado = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                imagenGato = new ImageIcon(modificado);
            }

            String[] botones = { "1. Ver otra imagen", "2. Favorito", "3. Volver" };
            String gatoId = gatos.getId();
            String opciones = (String) JOptionPane.showInputDialog(null, menuGatosAleatorio, gatoId,
                    JOptionPane.INFORMATION_MESSAGE, imagenGato, botones, botones[0]);

            //validacion que opcion seleccciono el usuario        
            int seleccion = -1;
            for (int i = 0; i < botones.length; i++) {
                if (opciones.equals(botones[i])) {
                    seleccion = i;
                }
            }

            switch (seleccion) {
                case 0:
                    verGatos();
                    break;
                case 1:
                    marcarComoFavorito(gatos);
                    break;
                default:
                    break;
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    
    public static void marcarComoFavorito(Gatos gatos) {
        
    }
    
}
