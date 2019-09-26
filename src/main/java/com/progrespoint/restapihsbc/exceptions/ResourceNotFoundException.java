package com.progrespoint.restapihsbc.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String errorMassage){
        super(errorMassage);
    }
}
