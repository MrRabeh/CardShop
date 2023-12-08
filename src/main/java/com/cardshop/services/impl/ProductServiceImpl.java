package com.cardshop.services.impl;

import com.cardshop.model.Product;
import com.cardshop.services.ProductServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


public class ProductServiceImpl implements ProductServices {

    protected HashSet<Product> listProduct = new HashSet<>();

    @Override
    @TimeLimiter(name = "addProductToHandl")
    public CompletableFuture<Product> servicetimeout(Product product){
        addProductToHandl(product);
        return CompletableFuture.supplyAsync(()->product);
    }

    @Override
    public void addProductToHandl(Product product) {
        System.out.println("ADD PRODUCT");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        listProduct.add(product);
        System.out.println("FIN PRODUCT");
    }

    @Override
    public String printShop() {
        StringBuilder builder = new StringBuilder("-- Menu --  \n");
        builder.append("product  | Quantity  | price  | Total \n");
        listProduct.stream().map(product -> builder.append(product.name() + " | " + product.quantity() + "|" + product.price() + " | " + product.total() + "\n")).collect(Collectors.joining());
        builder.append("total : " + totalProduct());
        return builder.toString();
    }

    @Override
    public int sizeProduct() {
        return listProduct.size();
    }

    @Override
    public double totalProduct() {
        return listProduct.stream().map(product -> product.total()).collect(Collectors.summingDouble(Double::doubleValue));
    }

    @Override
    public HashSet<Product> getAll() {
        return listProduct;
    }



}
