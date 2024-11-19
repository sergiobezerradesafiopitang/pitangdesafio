package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class TokenNotSendedException extends RuntimeException{

    public TokenNotSendedException(String message){
        super(message);
    }

    public TokenNotSendedException(String message, Throwable value){
        super(message, value);
    }

    public TokenNotSendedException(){
        super(Constantes.TOKEN_NOT_SENDED_EXCEPTION);
    }

}
