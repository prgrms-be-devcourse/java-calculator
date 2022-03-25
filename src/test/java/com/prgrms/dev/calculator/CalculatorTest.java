package com.prgrms.dev.calculator;

import com.prgrms.dev.Console;
import com.prgrms.dev.calculator.io.Input;
import com.prgrms.dev.calculator.io.Operator;
import com.prgrms.dev.calculator.io.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {
  Operator operator = new Operator() {
    @Override
    public int calculate(String formula) {
      return 0;
    }
  };
  Input input = new Console();
  Output output = new Console();
  Calculator calculator = new Calculator(operator, input, output);

  @Test
  @DisplayName("계산식 유효성 검사 성공한다.")
  void 계산식_유효성검사_Ok() throws Exception {
    String formula = "3 + 2 / 1 + 6 * 2 / 3";

    Method method = calculator.getClass().getDeclaredMethod("validateFormula", String.class);
    method.setAccessible(true);

    assertTrue((boolean)method.invoke(calculator, formula));
  }

  @Test
  @DisplayName("계산식 유효성 검사 실패한다.")
  void 계산식_유효성검사_Fail() throws Exception {
    String formula1 = "3 + a / 1 + 6 * 2 / 3";
    String formula2 = "3 + 2 / 1 + 6 * 2 / b";
    String formula3 = "3+ 2 / 1 + 6 * 2 / 3";
    String formula4 = "3 + 2 / 1 + 6 * 2 /3";

    Method method = calculator.getClass().getDeclaredMethod("validateFormula", String.class);
    method.setAccessible(true);

    assertFalse((boolean)method.invoke(calculator, formula1));
    assertFalse((boolean)method.invoke(calculator, formula2));
    assertFalse((boolean)method.invoke(calculator, formula3));
    assertFalse((boolean)method.invoke(calculator, formula4));
  }
}