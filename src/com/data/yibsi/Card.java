package com.data.yibsi;

import javax.swing.*;
import java.awt.*;

public class Card {

    String name;
    String meaning;
    String image;
    int status = 0;
    public Card(String name, String meaning, String image) {
        this.name = name;
        this.meaning = meaning;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }

    public String toHTMLString() {
        return "<html>" +
                "<body>" +
                    "<h1>" + name + "</h1>" +
                    "<p>" + meaning + "</p>" +
                "</body>" +
                "</html>";
    }

    public String getName() {
        return this.name;
    }

    public String getMeaning() {
        return this.meaning;
    }

    public String getImage() {
        return this.image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
