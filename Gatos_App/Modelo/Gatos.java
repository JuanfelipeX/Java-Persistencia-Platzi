package Gatos_App.Modelo;

public class Gatos {

    // Dotenv dotenv = Dotenv.load();

    String id;
    String url;
    String apiKey = "8c91e010-7212-476f-a2a5-60699ef11af3";
    String image;

    public Gatos(String id, String url, String apiKey, String image) {
        this.id = id;
        this.url = url;
        this.apiKey = apiKey;
        this.image = image;
    }
    
    public Gatos() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}