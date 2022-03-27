package programmers.calculator.processor.register;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BufferRegister implements Register<String> {

  Deque<String> buffer = new ArrayDeque<>();

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
