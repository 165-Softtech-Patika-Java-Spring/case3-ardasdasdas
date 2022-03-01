package com.softtech.bootcamp.case3.exception;

import com.softtech.bootcamp.case3.enums.errormessage.NotFoundErrorMessage;

public class NotFoundException extends Case3Exception{
    public NotFoundException(){
        super();
    }

    public NotFoundException(NotFoundErrorMessage notFoundErrorMessage){
        super(notFoundErrorMessage.getMessage());
    }

    public NotFoundException(String message){
        super(message);
    }

}
