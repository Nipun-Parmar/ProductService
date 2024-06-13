package com.scaler.productservice.controlleradvice;

import com.scaler.productservice.dtos.ExceptionHandlerDTO;
import com.scaler.productservice.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionHandlerDTO> handleProductNotExistsException(
            ProductNotExistsException exception
    ){
        ExceptionHandlerDTO exceptionDTO = new ExceptionHandlerDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setDetail("May be Product ID is Invalid. Try with a valid ID");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.OK);
    }
}
