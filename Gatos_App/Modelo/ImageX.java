package Gatos_App.Modelo;

public class ImageX {

    String id;
    String url;

    public ImageX(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public ImageX() {
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
    
}