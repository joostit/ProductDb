package com.joostit.productdb.controllers;

import com.joostit.productdb.dtos.ProductApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class ResponseBuilder {


    public static ResponseEntity<ProductApiResponse> notFond(String message){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ProductApiResponse.builder()
                        .timestamp(now())
                        .message(message)
                        .status(NOT_FOUND)
                        .statusCode(NOT_FOUND.value())
                        .build()
        );
    }


    public static <TObject> ResponseEntity<ProductApiResponse> ok(String dataName, TObject data, String message) {
        return ResponseEntity.ok(
                ProductApiResponse.builder()
                        .timestamp(now())
                        .data(of(dataName, data))
                        .message(message)
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
