package calculation.calculator.engine;

import calculation.calculator.engine.BigDecimalCalculator;
import calculation.calculator.engine.Calculator;
import calculation.calculator.expression.NormalExpressionService;
import calculation.calculator.expression.NormalArithmeticLogic;
import calculation.model.CalcData;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BigDecimalCalculatorTest {

  BigDecimalCalculator calculator = new BigDecimalCalculator
      (new NormalExpressionService(new NormalArithmeticLogic()));

  //잘못된 연산식 테스트
  @Test
  public void badExpressionTest() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("1 + 2+ 3"));// 연산자와 숫자사이에 공백이 없을 때
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute(" 1 + 2 + 3"));  //맨 앞에 공백이 있을 때
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("1 + 2 + 3 "));  //맨 뒤에 공백이 있을 때
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("1 ? 2 + 3"));// 연산자가 잘못 됐을 때
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("1 ++ 2 + 3"));  // 연산자가 공백 없이 연속으로 있을 때
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute(" 1 * * 2 + 3"));  //연산자가 올 위치가 아닐 때
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("1"));  //연산 식이 아닐 때 - 숫자 한 개
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("+"));  //연산 식이 아닐 때 - 연산자 한개
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.execute("a + b"));  //숫자가 아닌 다른 문자가 피연산자로 들어올 때

  }

  //정수 계산 테스트
  @Test
  public void BasicCalcTest() {
    String exp1 = "1 + 2";
    String exp2 = "5 - 15";
    String exp3 = "5 * 9";
    String exp4 = "10 / 2";
    String exp5 = "11 / 2";
    BigDecimal ans1 = new BigDecimal(3);
    BigDecimal ans2 = new BigDecimal(-10);
    BigDecimal ans3 = new BigDecimal(45);
    BigDecimal ans4 = new BigDecimal(5);
    BigDecimal ans5 = new BigDecimal(5.5);

    //when
    CalcData calculate1 = calculator.execute(exp1);
    CalcData calculate2 = calculator.execute(exp2);
    CalcData calculate3 = calculator.execute(exp3);
    CalcData calculate4 = calculator.execute(exp4);
    CalcData calculate5 = calculator.execute(exp5);

    //then
    Assertions.assertEquals(ans1, calculate1.getAns());
    Assertions.assertEquals(ans2, calculate2.getAns());
    Assertions.assertEquals(ans3, calculate3.getAns());
    Assertions.assertEquals(ans4, calculate4.getAns());
    Assertions.assertEquals(ans5, calculate5.getAns());
  }

  //실수 계산 테스트
  @Test
  public void actualNumCalcTest() {
    //given
    String exp1 = "1.5 + 1.2";
    String exp2 = "1.6 - 1.2";
    String exp3 = "1.3 / 1.4";
    String exp4 = "1.1 * 1.2";

    BigDecimal ans1 = new BigDecimal("2.7");
    BigDecimal ans2 = new BigDecimal("0.4");
    BigDecimal ans3 = new BigDecimal("0.9285714285714285714285714285714286");
    BigDecimal ans4 = new BigDecimal("1.32");

    //when
    CalcData calculate1 = calculator.execute(exp1);
    CalcData calculate2 = calculator.execute(exp2);
    CalcData calculate3 = calculator.execute(exp3);
    CalcData calculate4 = calculator.execute(exp4);

    //then
    Assertions.assertEquals(ans1, calculate1.getAns());
    Assertions.assertEquals(ans2, calculate2.getAns());
    Assertions.assertEquals(ans3, calculate3.getAns());
    Assertions.assertEquals(ans4, calculate4.getAns());
  }

  //복잡한 계산식 테스트
  @Test
  public void complexCalcTest() {
    //given
    String exp1 = "1 + 2 * 3";
    String exp2 = "0 * 1 / 1";
    String exp3 = "1 * 2 + 1 / 1 * 10";

    BigDecimal ans1 = new BigDecimal(7);
    BigDecimal ans2 = new BigDecimal(0);
    BigDecimal ans3 = new BigDecimal(12);

    //when
    CalcData calculate1 = calculator.execute(exp1);
    CalcData calculate2 = calculator.execute(exp2);
    CalcData calculate3 = calculator.execute(exp3);

    //then
    Assertions.assertEquals(ans1, calculate1.getAns());
    Assertions.assertEquals(ans2, calculate2.getAns());
    Assertions.assertEquals(ans3, calculate3.getAns());
  }

  //큰 숫자 계산 테스트
  @Test
  public void bigNumCalcTest() {
    //given
    String exp1 = "2147483647 + 2147483647";
    String exp2 = "1000000000000 * 1000000000000";
    BigDecimal ans1 = new BigDecimal("4294967294");
    BigDecimal ans2 = new BigDecimal("1000000000000000000000000");

    //when
    CalcData calculate1 = calculator.execute(exp1);
    CalcData calculate2 = calculator.execute(exp2);

    //then
    Assertions.assertEquals(ans1, calculate1.getAns());
    Assertions.assertEquals(ans2, calculate2.getAns());
  }

  //0으로 나누기 테스트
  @Test
  public void divideByZeroTest() {
    String exp1 = "1 / 0";
    String exp2 = "1 + 2 / 0";

    Assertions.assertThrows(ArithmeticException.class, () -> calculator.execute(exp1));
    Assertions.assertThrows(ArithmeticException.class, () -> calculator.execute(exp2));
  }
}