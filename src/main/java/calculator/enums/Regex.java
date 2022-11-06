package calculator.enums;

public enum Regex {
  NUMBER("[^0-9]"),
  OPERATION("[^+\\-*/]");

  private final String pattern;
  Regex(String pattern) {
    this.pattern = pattern;
  }

  public String getPattern(){
    return pattern;
  }
}
