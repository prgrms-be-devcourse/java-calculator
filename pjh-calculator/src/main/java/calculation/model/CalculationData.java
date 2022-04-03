package calculation.model;

import java.math.BigDecimal;

public class CalculationData {

  private Long id;
  private String expression;
  private BigDecimal answer;

  public void setId(Long id) {
    this.id = id;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public BigDecimal getAnswer() {
    return answer;
  }

  public CalculationData(String expression, BigDecimal answer) {
    this.expression = expression;
    this.answer = answer;
  }
}
