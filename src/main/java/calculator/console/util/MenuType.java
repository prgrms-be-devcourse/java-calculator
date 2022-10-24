package calculator.console.util;

public enum MenuType {
  CALCULATE("1"),
  HISTORY("2"),
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
