package Gatos_App.Servicios;

import com.google.gson.Gson;
import Gatos_App.Modelo.Gatos;
import Gatos_App.Modelo.GatosFavoritos;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GatosServicios {

    // RECORDAR QUE DEBEMOS DESCARGAR LOS ARCHIVOS JAR DE MYSQLCONNECTION, GSON Y
    // OKHHTP
    // PARA QUE FUNCIONE LA API Y CONFIGURARLOS E IMPORTALOS EN UN JSON

    // https://github.com/santiaguf/gatos_app/blob/master/src/main/java/com/platzi/gatos_app/service/CatService.java
    // REPOSITORIO DEL PROFESOR

    private static String BASE_URL = "https://api.thecatapi.com/v1/favourites/";
    private static String FAVORITE_ENDPOINT = BASE_URL + "favourites";

    private static String menuGatosAleatorio = "Opciones: \n"
            + " 1. ver otra imagen \n"
            + " 2. Favorito \n"
            + " 3. Volver \n";

    public static void verGatos() throws IOException {

        // trayendo datos de la api,
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();

        Response response = client.newCall(request).execute();
        String jsonDatos = response.body().string();

        // corta los corchetes del postman
        jsonDatos = jsonDatos.substring(1, jsonDatos.length());
        jsonDatos = jsonDatos.substring(0, jsonDatos.length() - 1);

        // crea el objeto de la clase GSON
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(jsonDatos, Gatos.class);

        // redimensionar la imagen
        Image imagen = null;

        try {
            URL url = new URL(gatos.getUrl());
            imagen = ImageIO.read(url);

            ImageIcon imagenGato = new ImageIcon(imagen);

            if (imagenGato.getIconWidth() > 800 && imagenGato.getIconHeight() > 600) {

                // redimensiona
                Image fondo = imagenGato.getImage();
                Image modificado = fondo.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
                imagenGato = new ImageIcon(modificado);
            }

            String[] botones = { "1. Ver otra imagen", "2. Favorito", "3. Volver" };
            String gatoId = gatos.getId(); // obtiene el id del gato
            String opciones = (String) JOptionPane.showInputDialog(null, "Seleccione alguna opcion :3",
                    "Cute Cats" + "   " + gatoId,
                    JOptionPane.INFORMATION_MESSAGE, imagenGato, botones, botones[0]);

            // validacion que opcion seleccciono el usuario
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
        try {

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\"" + gatos.getId() + "\"\n}");
            Request request = new Request.Builder()
                    .url(FAVORITE_ENDPOINT)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gatos.getApiKey())
                    .build();

            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                response.body().close();
            }

        } catch (Exception e) {
        }
    }

    public static void verFavoritos(String apiKey) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", apiKey)
                .build();

        Response response = client.newCall(request).execute();

        // Guardamos el string con la respuesta
        String elJson = response.body().string();

        // Creando el objeto gson
        Gson gson = new Gson();

        GatosFavoritos[] gatosArray = gson.fromJson(elJson, GatosFavoritos[].class);

        if (!response.isSuccessful()) {
            response.body().close();
        }

        if (gatosArray.length > 0) {

            // se prentende mostrar algun gato favorito aleatorio
            int min = 1;
            int max = gatosArray.length;
            int aleatorio = (int) (Math.random() * ((max - min) + 1)) + min;
            int indice = aleatorio - 1;

            GatosFavoritos gatosFavoritos = gatosArray[indice];

            // redimensionar la imagen
            Image image = null;

            try {
                URL url = new URL(gatosFavoritos.image.getUrl());
                image = ImageIO.read(url);

                ImageIcon imagenGato = new ImageIcon(image);

                if (imagenGato.getIconWidth() > 800 && imagenGato.getIconHeight() > 600) {

                    // redimensiona
                    Image fondo = imagenGato.getImage();
                    Image modificado = fondo.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
                    imagenGato = new ImageIcon(modificado);
                }

                String[] botones = { "1. Ver otra imagen", "2. Eliminar Favorito", "3. Volver" };
                String gatoId = gatosFavoritos.getId(); // obtiene el id del gato
                String opciones = (String) JOptionPane.showInputDialog(null, "Seleccione alguna opcion :3",
                        "Cute Cats" + "   " + gatoId,
                        JOptionPane.INFORMATION_MESSAGE, imagenGato, botones, botones[0]);

                // validacion que opcion seleccciono el usuario
                int seleccion = -1;
                for (int i = 0; i < botones.length; i++) {
                    if (opciones.equals(botones[i])) {
                        seleccion = i;
                    }
                }

                switch (seleccion) {
                    case 0:
                        verFavoritos(apiKey);
                        break;
                    case 1:
                        // borrarFavortio();
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public void borrarFavorito(GatosFavoritos gatoFav) {

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/" + gatoFav.getId() + "")
                    .delete(null)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gatoFav.getApiKey())
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                response.body().close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
