package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String message){
        super(message);
    }

    public EmailAlreadyExistsException(String message, Throwable value){
        super(message, value);
    }

    public EmailAlreadyExistsException(){
        super(Constantes.EMAIL_ALREADY_EXISTS_EXCEPTION);
    }

}
