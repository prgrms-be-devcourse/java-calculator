package programmers.calculator.processor.register;

import java.util.List;
import java.util.Stack;

public class BufferRegister implements Register<String> {

  Stack<String> buffer = new Stack<>();

  @Override
  public void save(String value) {
    buffer.push(value);
  }

  public void saveAll(List<String> values) {
    buffer.addAll(values);
  }

  @Override
  public List<String> popAll() {
    List<String> values = buffer.stream().toList();
    buffer.clear();
    return values;
  }

}
