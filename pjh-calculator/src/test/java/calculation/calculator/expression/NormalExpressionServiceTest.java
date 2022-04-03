package calculation.calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NormalExpressionServiceTest {

  private ExpressionService expressionService = new NormalExpressionService(new NormalArithmeticLogic());

  @DisplayName("후위 표기식 변경 테스트")
  @Test
  public void onlyAddConvertToPostfixTest() {
    //given
    List<String> expression1 = List.of("1", "+", "2");
    List<String> expression2 = List.of("1", "+", "2", "+", "3");
    List<String> expression3 = List.of("1", "+", "2", "+", "3", "+", "4", "+", "5");

    List<String> answer1 = List.of("1", "2", "+");
    List<String> answer2 = List.of("1", "2", "+", "3", "+");
    List<String> answer3 = List.of("1", "2", "+", "3", "+", "4", "+", "5", "+");

    //when
    List<String> result1 = expressionService.convertToPostfix(expression1);
    List<String> result2 = expressionService.convertToPostfix(expression2);
    List<String> result3 = expressionService.convertToPostfix(expression3);

    //then
    assertThat(result1).isEqualTo(answer1);
    assertThat(result2).isEqualTo(answer2);
    assertThat(result3).isEqualTo(answer3);
  }

  @Test
  public void complexConvertToPostfixTest() {
    //given
    List<String> expression1 = List.of("1", "/", "2", "+", "3");
    List<String> expression2 = List.of("1", "*", "2", "/", "3", "-", "5", "*", "1");

    List<String> answer1 = List.of("1", "2", "/", "3", "+");
    List<String> answer2 = List.of("1", "2", "*", "3", "/", "5", "1", "*", "-");

    //when
    List<String> result1 = expressionService.convertToPostfix(expression1);
    List<String> result2 = expressionService.convertToPostfix(expression2);

    //then
    assertThat(result1).isEqualTo(answer1);
    assertThat(result2).isEqualTo(answer2);

  }
}