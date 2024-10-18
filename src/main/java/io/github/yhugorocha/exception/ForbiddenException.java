package io.github.yhugorocha.exception;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(){
        super("Forbidden");
    }
    public ForbiddenException(String message){
        super(message);}
}
