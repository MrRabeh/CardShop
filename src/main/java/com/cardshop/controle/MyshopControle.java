package com.cardshop.controle;

import com.cardshop.extrenejson.FileJson;
import com.cardshop.extrenejson.ProductJson;
import com.cardshop.model.Product;
import com.cardshop.services.ProductServices;
import com.cardshop.services.impl.ProductServiceImpl;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MyshopControle {

    Logger log = Logger.getLogger(getClass().getName());

   private ProductServices productServices;

   public MyshopControle() {
       productServices = new ProductServiceImpl();
   }

   public void purchase(String name,double price,int quantity) {
       productServices.addProductToHandl(Product.builder().name(name).price(price).quantity(quantity).total(price*quantity).build());
   }

   public void print(){
       log.log(Level.INFO,"{}",productServices.printShop());
   }

   public FileJson persistance(){
       HashSet<ProductJson> productJsons = productServices.getAll().stream().map(ProductServices::produitJson).collect(Collectors.toCollection(HashSet::new));
       return FileJson.builder().total(productServices.totalProduct()).products(productJsons).build();
   }

}
