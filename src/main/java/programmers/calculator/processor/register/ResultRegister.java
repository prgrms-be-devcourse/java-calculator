package programmers.calculator.processor.register;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ResultRegister implements Register<Double> {

  Deque<Double> buffer = new ArrayDeque<>();

  @Override
  public void save(Double data) {
    buffer.push(data);
  }

  @Override
  public List<String> popAll() {
    List<String> symbols = new ArrayList<>();
    while (!buffer.isEmpty()) {
      symbols.add(String.valueOf(buffer.pop()));
    }
    return symbols;
  }

  public Double pop() {
    return buffer.pop();
  }
}
