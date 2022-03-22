package com.programmers.devcourse.parser.exception;

public class WrongTokenCountException extends ParserException {

  @Override
  public String getMessage() {
    return "연산자, 숫자 개수가 적합하지 않습니다.";
  }
}
