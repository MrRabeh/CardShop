package com.cardshop.extrenejson;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Builder
@Jacksonized
@Data
public class ProductJson implements Serializable {
     String name;
     int quantity;
     double price;
     double total;

}
