package programmers.calculator.processor.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import programmers.calculator.processor.arithmetic.Operator;

public class OperatorRegister implements Register<Operator> {

  Stack<Operator> buffer = new Stack<>();

  @Override
  public void save(Operator operator) {
    buffer.push(operator);
  }

  public List<String> popTrailingSymbols(Operator operator) {
    if (buffer.isEmpty() || !buffer.peek().isPreceding(operator)) {
      return new ArrayList<>();
    }
    return popAll();
  }

  @Override
  public List<String> popAll() {
    List<String> symbols = new ArrayList<>();
    while (!buffer.isEmpty()) {
      symbols.add(buffer.pop().getSymbol());
    }
    return symbols;
  }
}
