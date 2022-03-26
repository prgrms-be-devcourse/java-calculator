package programmers.calculator.controller;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import programmers.calculator.memory.Memory;
import programmers.calculator.processor.Processor;

@AllArgsConstructor
public class ControlUnit {

  private final Parser parser;
  private final Processor processor;
  private final Memory<String, String> memory;

  public String printHistory() {
    StringBuilder sb = new StringBuilder();
    memory.findAll().
        forEach((value) -> sb.append(value).append("\n"));
    return sb.toString();
  }

  public String execute(String input) {
    Optional<String> cache = memory.find(input);
    if (cache.isPresent()) {
      memory.save(input, cache.get());
      return cache.get();
    }

    String result = getResult(input);
    memory.save(input, result);
    return result;
  }

  private String getResult(String input) {
      List<String> tokens = parser.parse(input);
      List<String> postfixOrder = toPostfix(tokens);
      return format(cycle(postfixOrder));
  }

  private List<String> toPostfix(List<String> tokens) {
    tokens.forEach(processor::writeBuffer);
    return processor.readBuffer();
  }

  private double cycle(List<String> tokens) {
    tokens.forEach(processor::writeResult);
    return processor.readResult();
  }

  private String format(double value) {
    if (value == (long) value) {
      return Long.toString((long) value);
    }
    return Double.toString(Math.round(value * 100.0) / 100.0);
  }
}
