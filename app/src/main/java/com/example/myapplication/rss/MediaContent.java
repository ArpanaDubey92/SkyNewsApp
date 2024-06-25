package com.example.myapplication.rss;// Rss.java
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

// Channel.java


// Image.java

// Item.java

// Enclosure.java

// MediaContent.java


@Root(name = "media:content", strict = false)
public class MediaContent {

    @Attribute(name = "url")
    private String url;

    @Attribute(name = "type")
    private String type;

    // Getters and setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


