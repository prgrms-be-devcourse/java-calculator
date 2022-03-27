package programmers.calculator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import programmers.calculator.repository.Repository;
import programmers.calculator.processor.Processor;

@AllArgsConstructor
public class ControlUnit {

  public static final double DIGIT_FORMAT = 100.0;
  private static final String WHITE_SPACE_SPLIT_REGEX = "\\s";
  private final Processor processor;
  private final Repository<String, String> repository;

  public String printHistory() {
    StringBuilder sb = new StringBuilder();
    repository.findAll().
        forEach((value) -> sb.append(value).append("\n"));
    return sb.toString();
  }

  public String execute(String input) {
    Optional<String> cache = repository.find(input);
    if (cache.isPresent()) {
      repository.save(input, cache.get());
      return cache.get();
    }

    String result = getResult(input);
    repository.save(input, result);
    return result;
  }

  private String getResult(String input) {
    List<String> tokens = parse(input);
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
    return Double.toString(Math.round(value * DIGIT_FORMAT) / DIGIT_FORMAT);
  }

  public List<String> parse(String input) {
    List<String> tokens = Arrays.asList(input.split(WHITE_SPACE_SPLIT_REGEX));
    Validator.validate(tokens);
    return tokens;
  }

}
