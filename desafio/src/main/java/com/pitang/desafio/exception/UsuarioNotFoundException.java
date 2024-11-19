package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String message){
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable value){
        super(message, value);
    }

    public UsuarioNotFoundException(){
        super(Constantes.USUARIO_NOT_FOUND_EXCEPTION);
    }

}
