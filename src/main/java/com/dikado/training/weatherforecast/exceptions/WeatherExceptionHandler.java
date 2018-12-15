package com.dikado.training.weatherforecast.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WeatherExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({HttpClientErrorException.BadRequest.class})
    public ResponseEntity<Object> handleNotFoundException(HttpClientErrorException.BadRequest exception, WebRequest request){
        return new ResponseEntity<Object>("Bad Request: Parameter not valid", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Object> handleNotFoundException(HttpClientErrorException.NotFound exception, WebRequest request){
        return new ResponseEntity<Object>("Resource Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
