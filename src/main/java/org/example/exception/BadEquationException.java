package org.example.exception;

public class BadEquationException extends RuntimeException{
    private static final String msg = "잘못된 수식이 입력 되었습니다.";
    public BadEquationException(){
        super(msg);
    }
}
