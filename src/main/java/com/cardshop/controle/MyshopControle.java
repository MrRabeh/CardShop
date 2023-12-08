package com.cardshop.controle;

import com.cardshop.extrenejson.FileJson;
import com.cardshop.extrenejson.ProductJson;
import com.cardshop.model.Product;
import com.cardshop.services.ProductServices;
import com.cardshop.services.impl.ProductServiceImpl;

import java.util.HashSet;
import java.util.stream.Collectors;

public class MyshopControle {

   private ProductServices productServices;

   public MyshopControle() {
       productServices = new ProductServiceImpl();
   }

   public void purchase(String name,double price,int quantity) {
       productServices.addProductToHandl(Product.builder().name(name).price(price).quantity(quantity).total(price*quantity).build());
   }

   public void print(){
       System.out.println(productServices.printShop());
   }

   public FileJson Persistance(){
       HashSet<ProductJson> productJsons = productServices.getAll().stream().map(ProductServices::produitJson).collect(Collectors.toCollection(HashSet::new));
       return FileJson.builder().total(productServices.totalProduct()).products(productJsons).build();
   }

}
