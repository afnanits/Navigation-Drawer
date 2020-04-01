package org.example.vaccinationapp;

public class NEWS {
String url,imageUrl,text;

    public NEWS(String url, String imageUrl, String text) {
        this.url = url;
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getText() {
        return text;
    }
}
