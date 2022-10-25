package calculator.enums;

public enum MenuType {
  CALCULATE("1"),
  HISTORY("2"),
  //메뉴에 없는 숫자 입력시 EXIT 상태가 되는데, EXIT의 다른 값을 -1로 설정해놓았습니다.
  //enum에 정의된 EXIT 상태와 실제 종료 조건이 다른 것을 고치고 싶습니다.
  EXIT("-1");

  final private String value;
  MenuType(String value) {
    this.value = value;
  }

  public String getValue(){
    return value;
  }

  public static boolean isCalculate(String input){
    return input.equals(CALCULATE.getValue());
  }

  public static boolean isHistory(String input){
    return input.equals(HISTORY.getValue());
  }
}
