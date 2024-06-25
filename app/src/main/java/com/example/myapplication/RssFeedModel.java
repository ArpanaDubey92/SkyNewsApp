package com.example.myapplication;

public class RssFeedModel {
    private String title;
    private String description;
    private String link;
    private String imageUrl;

    public RssFeedModel(String title, String description, String link, String imageUrl) {
        this.title = title;
        this.description= description;
        this.link = link;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "RssFeedModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
