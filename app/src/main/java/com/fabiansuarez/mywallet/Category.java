package com.fabiansuarez.mywallet;

public class Category {

    private String name;
    private String description;
    private String color;
    private String iconUrl;

    public Category(String name, String description, String color, String iconUrl) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.iconUrl = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
