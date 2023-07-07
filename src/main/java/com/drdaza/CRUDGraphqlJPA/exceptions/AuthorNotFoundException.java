package com.drdaza.CRUDGraphqlJPA.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message){
        super(message);
    }
}
