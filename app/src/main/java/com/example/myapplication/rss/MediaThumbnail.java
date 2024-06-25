package com.example.myapplication.rss;// Rss.java

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "media:thumbnail", strict = false)
public class MediaThumbnail {

    @Attribute(name = "url")
    private String url;

    @Attribute(name = "width")
    private int width;

    @Attribute(name = "height")
    private int height;

    // Getters and setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
