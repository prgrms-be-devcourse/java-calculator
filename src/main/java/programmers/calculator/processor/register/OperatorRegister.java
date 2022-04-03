package programmers.calculator.processor.register;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import programmers.calculator.processor.arithmetic.Operator;

public class OperatorRegister implements Register<Operator> {

  Deque<Operator> buffer = new ArrayDeque<>();

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
