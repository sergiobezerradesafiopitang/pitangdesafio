package com.pitang.desafio.exception;

import com.pitang.desafio.constants.Constantes;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message){
        super(message);
    }

    public CarNotFoundException(String message, Throwable value){
        super(message, value);
    }

    public CarNotFoundException(){
        super(Constantes.CARRO_NOT_FOUND_EXCEPTION);
    }

}
