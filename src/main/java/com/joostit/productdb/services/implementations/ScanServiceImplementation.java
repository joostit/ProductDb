package com.joostit.productdb.services.implementations;

import com.joostit.productdb.dtos.BarcodeResponse;
import com.joostit.productdb.entities.Product;
import com.joostit.productdb.repos.ProductRepository;
import com.joostit.productdb.services.ScanService;
import org.springframework.stereotype.Service;

@Service
public class ScanServiceImplementation implements ScanService {



    private final ProductRepository productRepo;

    public ScanServiceImplementation(ProductRepository pRepo){
        this.productRepo = pRepo;
    }

    public BarcodeResponse GetBarcodeResponse(String ean){

        BarcodeResponse retVal = null;
        Product product = productRepo.findByEan(ean);

        if(product != null){
            retVal = BarcodeResponse.builder()
                    .name(product.getName())
                    .ean(product.getEan())
                    .price(product.getPrice())
                    .build();
        }

        return retVal;
    }

}
