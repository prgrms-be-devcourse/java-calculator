package calculation.calculator.expression;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NormalExpressionServiceTest {

  private ExpressionService expressionService = new NormalExpressionService(new NormalArithmeticLogic());

  private Boolean compare(List a, List b) {
    Iterator iterA = a.iterator();
    Iterator iterB = b.iterator();
    while (iterA.hasNext() && iterB.hasNext()) {
      if (!iterA.next().equals(iterB.next())) {
        return false;
      }
    }
    if (!iterA.hasNext() && !iterB.hasNext()) {
      return true;
    }
    return false;
  }

  //후위 표기식 변경 테스트
  @Test
  public void onlyAddConvertToPostfixTest() {
    //given

    List<String> exp1 = List.of("1", "+", "2");
    List<String> exp2 = List.of("1", "+", "2", "+", "3");
    List<String> exp3 = List.of("1", "+", "2", "+", "3", "+", "4", "+", "5");

    List<String> ans1 = List.of("1", "2", "+").stream().collect(Collectors.toList());
    List<String> ans2 = List.of("1", "2", "+", "3", "+").stream().collect(Collectors.toList());
    List<String> ans3 = List.of("1", "2", "+", "3", "+", "4", "+", "5", "+").stream().collect(Collectors.toList());

    //when
    List<String> data1 = expressionService.convertToPostfix(exp1);
    List<String> data2 = expressionService.convertToPostfix(exp2);
    List<String> data3 = expressionService.convertToPostfix(exp3);
    System.out.println(data3);

    Boolean same = compare(data1, ans1);
    Boolean same2 = compare(data2, ans2);
    Boolean same3 = compare(data3, ans3);
    //then
    Assertions.assertTrue(same);
    Assertions.assertTrue(same2);
    Assertions.assertTrue(same3);
  }

  @Test
  public void complexConvertToPostfixTest() {
    //given
    List<String> exp1 = List.of("1", "/", "2", "+", "3");
    List<String> exp2 = List.of("1", "*", "2", "/", "3", "-", "5", "*", "1");

    List<String> ans1 = List.of("1", "2", "/", "3", "+").stream().collect(Collectors.toList());
    List<String> ans2 = List.of("1", "2", "*", "3", "/", "5", "1", "*", "-").stream().collect(Collectors.toList());

    //when
    List<String> data1 = expressionService.convertToPostfix(exp1);
    List<String> data2 = expressionService.convertToPostfix(exp2);
    Boolean same = compare(data1, ans1);
    Boolean same2 = compare(data2, ans2);

    //then
    Assertions.assertTrue(same);
    Assertions.assertTrue(same2);
  }
}