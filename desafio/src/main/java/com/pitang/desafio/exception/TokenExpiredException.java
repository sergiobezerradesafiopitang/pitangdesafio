package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException(String message){
        super(message);
    }

    public TokenExpiredException(String message, Throwable value){
        super(message, value);
    }

    public TokenExpiredException(){
        super(Constantes.TOKEN_EXPIRED_EXCEPTION);
    }

}
