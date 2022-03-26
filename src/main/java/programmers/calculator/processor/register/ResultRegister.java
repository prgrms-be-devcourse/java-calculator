package programmers.calculator.processor.register;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ResultRegister implements Register<Double> {

  Stack<Double> buffer = new Stack<>();

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
