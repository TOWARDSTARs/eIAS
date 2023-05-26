package com.project.eIASbackend.exception;

/************************
 * eIASbackend
 * com.project.eIASbackend.exception
 * MHC
 * author : zxin
 * date:  2023/5/13 14:13
 * description : 
 ************************/
public class SameMaterialNameException extends Exception{
    public SameMaterialNameException(String message){
        super(message);
    }
}
