package calculation.model;

import java.math.BigDecimal;

public class CalcData {
  Long id;
  String expression;
  BigDecimal ans;

  public String getExpression() {
    return expression;
  }

  public BigDecimal getAns() {
    return ans;
  }

  public void setId(Long id)
  {
   this.id = id;
  }

  public CalcData(String expression, BigDecimal ans) {
    this.expression = expression;
    this.ans = ans;
  }
}
