package io.github.yhugorocha.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super("NotFound");
    }
    public NotFoundException(String message){
        super(message);}
}
