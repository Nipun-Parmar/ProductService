package com.scaler.productservice.exceptions;

import com.scaler.productservice.models.Product;

public class ProductNotExistsException extends Exception{
    public ProductNotExistsException(String message){
        super(message);
    }
}
