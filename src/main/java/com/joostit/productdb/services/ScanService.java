package com.joostit.productdb.services;

import com.joostit.productdb.dtos.BarcodeResponse;
import com.joostit.productdb.repos.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public interface ScanService {

    BarcodeResponse GetBarcodeResponse(String ean);

}
