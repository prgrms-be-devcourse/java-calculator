package org.example.history;

public class Formula {
  private String formula;
  private double result;

  public Formula(String formula, double result) {
    this.formula = formula;
    this.result = result;
  }

  @Override
  public String toString() {
    return this.formula + " = " + this.result;
  }
}
