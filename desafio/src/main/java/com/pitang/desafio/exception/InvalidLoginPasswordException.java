package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class InvalidLoginPasswordException extends RuntimeException{

    public InvalidLoginPasswordException(String message){
        super(message);
    }

    public InvalidLoginPasswordException(String message, Throwable value){
        super(message, value);
    }

    public InvalidLoginPasswordException(){
        super(Constantes.INVALID_LOGIN_PASSWORD_EXCEPTION);
    }

}
