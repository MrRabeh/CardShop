package com.cardshop.services;

import com.cardshop.extrenejson.ProductJson;
import com.cardshop.model.Product;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;

public interface ProductServices {

    public CompletableFuture<Product> servicetimeout(Product product);

    public void addProductToHandl(Product product);

    public String printShop();

    public int sizeProduct();

    public double totalProduct();

    public HashSet<Product> getAll();

    public static ProductJson produitJson(Product product) {
      return  ProductJson.builder().name(product.name()).price(product.price()).quantity(product.quantity()).total(product.total()).build();
    }
}
