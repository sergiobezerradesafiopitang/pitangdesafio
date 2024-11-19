package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class PlacaAlreadyExistsException extends RuntimeException{

    public PlacaAlreadyExistsException(String message){
        super(message);
    }

    public PlacaAlreadyExistsException(String message, Throwable value){
        super(message, value);
    }

    public PlacaAlreadyExistsException(){
        super(Constantes.PLACA_ALREADY_EXIXTS_EXCEPTION);
    }

}
