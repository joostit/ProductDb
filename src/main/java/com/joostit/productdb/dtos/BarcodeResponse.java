package com.joostit.productdb.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BarcodeResponse {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    private String ean;

}
