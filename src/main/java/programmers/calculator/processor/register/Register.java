package programmers.calculator.processor.register;

import java.util.List;

public interface Register<T> {

  void save(T data);

  List<String> popAll();
}
