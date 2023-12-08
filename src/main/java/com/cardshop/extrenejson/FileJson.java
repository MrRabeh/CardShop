package com.cardshop.extrenejson;


import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.HashSet;
@Builder
@Jacksonized
@Data
public class FileJson implements Serializable {

    double total;

    HashSet<ProductJson> products;
}
