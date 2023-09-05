package com.joostit.productdb.controllers;

import com.joostit.productdb.dtos.BarcodeResponse;
import com.joostit.productdb.dtos.ProductApiResponse;
import com.joostit.productdb.services.ScanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/scan")
public class ScanApiController {

    private final ScanService scanService;

    public ScanApiController(ScanService sService){
        this.scanService = sService;
    }

    @GetMapping("/{ean}")
    public ResponseEntity<ProductApiResponse> findUserById(@PathVariable(value = "ean") String ean) {

        BarcodeResponse foundProduct = scanService.GetBarcodeResponse(ean);

        if(foundProduct != null){
            return ResponseBuilder.ok("product", foundProduct, "Product found");
        }
        else{
            return ResponseBuilder.notFond("Product not found");
        }


    }

}
