package programmers.calculator.processor.register;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BufferRegister implements Register<String> {

  Deque<String> buffer = new ArrayDeque<>();

  @Override
  public void save(String value) {
    buffer.push(value);
  }

  public void saveAll(List<String> values) {
    values.forEach(buffer::push);
  }

  @Override
  public List<String> popAll() {
    List<String> values = new ArrayList<>();
    while (!buffer.isEmpty()) {
      values.add(buffer.removeLast());
    }
    return values;
  }

}
