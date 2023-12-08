package com.cardshop;

import com.cardshop.controle.MyshopControle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {

    static MyshopControle myshopControle = new MyshopControle();
    public static void main(String[] args) {

        myshopControle.purchase("Pen",1.50,3);
        myshopControle.purchase("Book",8.00,2);

        myshopControle.print();

        try {
             new ObjectMapper().writeValue(new File("C:\\temp\\FileJson.json"),myshopControle.Persistance());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}