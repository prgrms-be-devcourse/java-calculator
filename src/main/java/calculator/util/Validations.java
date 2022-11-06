package calculator.util;

import calculator.enums.Regex;

//문제점 : 일반 클래스이고, static 메서드 단 하나만 갖고 있음. 클래스로 꼭 둬야할까요?
public class Validations {
  //String 배열의 length가 똑같으면 정상적인 계산식인 것으로 validate
  public static boolean correctEquation(String equation){
    String[] operations = equation.split(Regex.OPERATION.getPattern());
    String[] numbers = equation.split(Regex.NUMBER.getPattern());
    return operations.length == numbers.length;
  }
}
