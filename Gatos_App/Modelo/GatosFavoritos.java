package Gatos_App.Modelo;

public class GatosFavoritos {

    String id;
    String image_id;
    String apiKey = "8c91e010-7212-476f-a2a5-60699ef11af3";

    public ImageX image;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage_id() {
        return image_id;
    }
    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    public ImageX getImagen() {
        return image;
    }
    public void setImagen(ImageX image) {
        this.image = image;
    }
}


