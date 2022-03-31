package com.programmers.devcourse.exception.processor;

public class WrongOperatorTokenException extends ProcessorException {

  @Override
  public String getMessage() {
    return "연산자 토큰이 잘못 입력됐습니다.";
  }
}
