package com.rank.assesment.casino_backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class PlayerInsufficientFundsException 
    extends RuntimeException{
    
        PlayerInsufficientFundsException(String exception){
            super(exception);
        }
}
