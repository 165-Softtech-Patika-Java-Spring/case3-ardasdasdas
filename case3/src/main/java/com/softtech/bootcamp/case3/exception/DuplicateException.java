package com.softtech.bootcamp.case3.exception;

import com.softtech.bootcamp.case3.enums.errormessage.DuplicateErrorException;

public class DuplicateException extends Case3Exception{

    public DuplicateException(){
        super();
    }

    public DuplicateException(DuplicateErrorException duplicateErrorException){
        super(duplicateErrorException.getMessage());
    }
}
