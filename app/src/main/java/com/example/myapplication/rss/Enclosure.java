package com.example.myapplication.rss;// Rss.java
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;


@Root(name = "enclosure", strict = false)
public class Enclosure {

    @Attribute(name = "url")
    private String url;

    @Attribute(name = "length")
    private long length;

    @Attribute(name = "type")
    private String type;

    // Getters and setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

// MediaContent.java
