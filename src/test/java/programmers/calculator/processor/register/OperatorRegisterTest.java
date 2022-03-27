package programmers.calculator.processor.register;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.calculator.processor.arithmetic.Operator;

class OperatorRegisterTest {

  OperatorRegister operatorRegister = new OperatorRegister();

  @Test
  @DisplayName("들어온 연산자의 우선순위가 작으면 레지스터를 비운다")
  void popTrailingSymbols() {
    operatorRegister.save(Operator.MULTIPLY);
    operatorRegister.save(Operator.DIVIDE);

    List<String> trailingSymbols = operatorRegister.popTrailingSymbols(Operator.ADD);
    assertThat(trailingSymbols).containsExactly("/", "*");
    assertThat(operatorRegister.popAll().size()).isEqualTo(0);
  }

  @Test
  @DisplayName("우선순위가 높지 않은 연산자가 들어오면 빈 리스트를 반환한다")
  void notTrailingSymbols() {
    operatorRegister.save(Operator.ADD);
    operatorRegister.save(Operator.SUBTRACT);

    List<String> trailingSymbols = operatorRegister.popTrailingSymbols(Operator.MULTIPLY);
    assertThat(trailingSymbols).isEmpty();
    assertThat(operatorRegister.popAll().size()).isEqualTo(2);
  }
}