package calculator.util;

//연산자를 담당하는 클래스
//클래스가 전체적으로 마음에 들지 않습니다...
//enum 활용방법, 객체지향적 설계 방법 등 전체적으로 다시 생각해봐야 할 것 같습니다
//메서드도 사용하는 입장에서 파라미터 순서 등 사용법이 명확하지 않습니다.
public class Operations {

  public static boolean isOperator(String operator){
    return operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*");
  }

  public static boolean isBigger(String operation1, String operation2) {
    if(operation1.equals("+") || operation1.equals("-")){
      return false;
    } else{
      return operation2.equals("+") || operation2.equals("-");
    }
  }

  public static Integer calculate(int a, String operator, int b) {
    if (operator.equals("+")) {
      return a + b;
    }
    if (operator.equals("-")) {
      return a - b;
    }
    if (operator.equals("*")) {
      return a * b;
    }
    if (operator.equals("/")) {
      return a / b;
    }

    throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
  }
}
