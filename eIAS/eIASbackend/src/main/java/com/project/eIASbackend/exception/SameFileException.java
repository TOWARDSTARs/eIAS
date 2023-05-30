package com.project.eIASbackend.exception;

/************************
 * eIASbackend
 * com.project.eIASbackend.exception
 * MHC
 * author : zxin
 * date:  2023/5/13 14:12
 * description : 
 ************************/
public class SameFileException extends RuntimeException{
    public SameFileException(String message){
        super(message);
    }
}
