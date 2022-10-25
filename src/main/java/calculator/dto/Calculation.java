package calculator.dto;

public class Calculation {
  private String equation;
  private int result;

  public Calculation(String equation, int result){
    this.equation = equation;
    this.result = result;
  }

  public String getEquation() {
    return equation;
  }

  public int getResult() {
    return result;
  }

  @Override
  public String toString() {
    return equation + " = " + result;
  }

  //equals와 hashCode를 재정의해서 HashMap의 성능을 높이는 것이 의미있는 리팩토링일까요?
}
