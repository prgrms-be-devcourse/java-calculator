package calculation.calculator.expression;

import static org.junit.jupiter.api.Assertions.*;

import calculation.model.CalcData;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NormalArithmeticLogicTest {

  ArithmeticLogic arithmeticLogic = new NormalArithmeticLogic();

  @Test
  void getPriorityTest() {
    int priorityMul = arithmeticLogic.getPriority("*");
    int priorityDiv = arithmeticLogic.getPriority("/");
    int priorityAdd = arithmeticLogic.getPriority("+");
    int prioritySub = arithmeticLogic.getPriority("-");

    Assertions.assertTrue(priorityAdd == prioritySub);
    Assertions.assertTrue(priorityMul == priorityDiv);
    Assertions.assertTrue(priorityMul > priorityAdd);
    Assertions.assertTrue(priorityMul > prioritySub);
    Assertions.assertTrue(priorityDiv > priorityAdd);
    Assertions.assertTrue(priorityDiv > prioritySub);
  }

  //정수 계산 테스트
  @Test
  public void BasicCalcTest() {

    BigDecimal ans1 = new BigDecimal(3);
    BigDecimal ans2 = new BigDecimal(-10);
    BigDecimal ans3 = new BigDecimal(45);
    BigDecimal ans4 = new BigDecimal(5);
    BigDecimal ans5 = new BigDecimal(5.5);

    //when
    BigDecimal calculate1 = arithmeticLogic.calculate("+", BigDecimal.valueOf(1), BigDecimal.valueOf(2));
    BigDecimal calculate2 = arithmeticLogic.calculate("-", BigDecimal.valueOf(5), BigDecimal.valueOf(15));
    BigDecimal calculate3 = arithmeticLogic.calculate("*", BigDecimal.valueOf(5), BigDecimal.valueOf(9));
    BigDecimal calculate4 = arithmeticLogic.calculate("/", BigDecimal.valueOf(10), BigDecimal.valueOf(2));
    BigDecimal calculate5 = arithmeticLogic.calculate("/", BigDecimal.valueOf(11), BigDecimal.valueOf(2));

    //then
    Assertions.assertEquals(ans1, calculate1);
    Assertions.assertEquals(ans2, calculate2);
    Assertions.assertEquals(ans3, calculate3);
    Assertions.assertEquals(ans4, calculate4);
    Assertions.assertEquals(ans5, calculate5);
  }

  //실수 계산 테스트
  @Test
  public void actualNumCalcTest() {

    BigDecimal ans1 = new BigDecimal("2.7");
    BigDecimal ans2 = new BigDecimal("0.4");
    BigDecimal ans3 = new BigDecimal("0.9285714285714285714285714285714286");
    BigDecimal ans4 = new BigDecimal("1.32");

    //when
    BigDecimal calculate1 = arithmeticLogic.calculate("+", BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.2));
    BigDecimal calculate2 = arithmeticLogic.calculate("-", BigDecimal.valueOf(1.6), BigDecimal.valueOf(1.2));
    BigDecimal calculate3 = arithmeticLogic.calculate("/", BigDecimal.valueOf(1.3), BigDecimal.valueOf(1.4));
    BigDecimal calculate4 = arithmeticLogic.calculate("*", BigDecimal.valueOf(1.1), BigDecimal.valueOf(1.2));

    //then
    Assertions.assertEquals(ans1, calculate1);
    Assertions.assertEquals(ans2, calculate2);
    Assertions.assertEquals(ans3, calculate3);
    Assertions.assertEquals(ans4, calculate4);
  }

  //큰 숫자 계산 테스트
  @Test
  public void bigNumCalcTest() {
    //given
    String ans1 = "4294967294";
    String ans2 = "1000000000000000000000000";

    //when
    BigDecimal calculate1 = arithmeticLogic.calculate("+", BigDecimal.valueOf(2147483647), BigDecimal.valueOf(2147483647));
    BigDecimal calculate2 = arithmeticLogic.calculate("*", BigDecimal.valueOf(1000000000000L), BigDecimal.valueOf(1000000000000L));

    //then
    Assertions.assertEquals(new BigDecimal(ans1), calculate1);
    Assertions.assertEquals(new BigDecimal(ans2), calculate2);
  }

  //0으로 나누기 테스트
  @Test
  public void divideByZeroTest() {
    Assertions.assertThrows(ArithmeticException.class, () -> arithmeticLogic.calculate("/",BigDecimal.valueOf(1),BigDecimal.valueOf(0)));
    Assertions.assertThrows(ArithmeticException.class, () -> arithmeticLogic.calculate("/",BigDecimal.valueOf(10000),BigDecimal.valueOf(0)));
  }
}