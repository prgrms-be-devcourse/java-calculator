package programmers.calculator.processor.register;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRegister implements Register<Double> {

  Deque<Double> buffer = new ArrayDeque<>();

  @Override
  public void save(Double data) {
    buffer.push(data);
  }

  @Override
  public List<String> popAll() {
    List<String> values = buffer.stream().map(Object::toString).collect(Collectors.toList());
    buffer.clear();
    return values;
  }

  public Double pop() {
    return buffer.pop();
  }
}
