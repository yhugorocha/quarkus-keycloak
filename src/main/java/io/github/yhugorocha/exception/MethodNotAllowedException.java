package io.github.yhugorocha.exception;

public class MethodNotAllowedException extends RuntimeException{

    public MethodNotAllowedException(){
        super("MethodNotAllowed");
    }
    public MethodNotAllowedException(String message){
        super(message);}
}
