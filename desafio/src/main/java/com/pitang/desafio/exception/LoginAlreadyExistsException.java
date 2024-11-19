package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class LoginAlreadyExistsException extends RuntimeException{

    public LoginAlreadyExistsException(String message){
        super(message);
    }

    public LoginAlreadyExistsException(String message, Throwable value){
        super(message, value);
    }

    public LoginAlreadyExistsException(){
        super(Constantes.LOGIN_ALREADY_EXISTS_EXCEPTION);
    }

}
