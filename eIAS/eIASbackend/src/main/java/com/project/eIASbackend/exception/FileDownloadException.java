package com.project.eIASbackend.exception;

public class FileDownloadException extends RuntimeException{
    public FileDownloadException(String message){
        super(message);
    }
}
