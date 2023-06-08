package org.example.exception;

public class BadEquationException extends RuntimeException{
    public BadEquationException(String str){
        super(str);
    }
}
