package com.cardshop;

import com.cardshop.controle.MyshopControle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {

    static MyshopControle myshopControle = new MyshopControle();
    public static void main(String[] args) {

        myshopControle.purchase("Pen",1.50,3);
        myshopControle.purchase("Book",8.00,2);

        myshopControle.print();

        try {
             new ObjectMapper().writeValue(new File(getUrlJson()),myshopControle.persistance());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

    private static String getUrlJson() {
        return URI.create("C:\\temp\\FileJson.json").getPath();
    }
}