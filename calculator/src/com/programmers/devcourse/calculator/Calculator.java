package com.programmers.devcourse.calculator;

import com.programmers.devcourse.exception.CalculatorException;
import com.programmers.devcourse.io.Input;
import com.programmers.devcourse.io.Output;
import com.programmers.devcourse.model.Result;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.processor.Processor;
import com.programmers.devcourse.repository.ResultRepository;
import java.io.IOException;
import java.util.List;

public class Calculator {

  private final Parser parser;
  private final ResultRepository<String, Double> repository;
  private final Processor<List<String>, Double> processor;
  private final Input input;
  private final Output output;

  public Calculator(Parser parser, Processor<List<String>, Double> processor,
      Input input, Output output, ResultRepository<String, Double> repository) {
    this.parser = parser;
    this.input = input;
    this.output = output;
    this.repository = repository;

    this.processor = processor;
  }

  public void start() {
    Mode mode;
    try (input; output;) {
      label:
      while (true) {
        mode = Mode.from(input.getMenuSelection());
        switch (mode) {
          case PRINT_RESULT:
            output.sendAllResults(repository.getAll());
            break;
          case CALCULATE:
            handleExpressionFromConsole();
            break;
          case EXIT:
            output.sendMessage("계산기 종료");
            break label;
          default:
            output.sendMessage("일치하는 메뉴가 없습니다.\n");
            break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
      output.sendMessage("입출력 오류");
    }

  }


  private void handleExpressionFromConsole() throws IOException {
    String expression = input.getExpression();
    Result<String, Double> result;
    try {

      result = formatAndCalculateExpression(expression);

    } catch (CalculatorException e) {

      output.sendMessage(e.getMessage() + "\n");
      return;

    }

    repository.save(result.getKey(), result.getValue());
    output.sendMessage(result.getValue() + "\n");
  }

  private Result<String, Double> formatAndCalculateExpression(String expression)
      throws CalculatorException {
    List<String> tokens;
    tokens = parser.parse(expression);
    String formattedExpression = mapTokensToFormattedExpression(tokens);
    double result = processor.process(tokens);

    return new Result<>(formattedExpression, result);
  }

  private String mapTokensToFormattedExpression(List<String> tokens) {
    StringBuilder sb = new StringBuilder();
    tokens.forEach(token -> {
      sb.append(token);
      sb.append(" ");
    });
    sb.delete(sb.length() - 1, sb.length());
    return sb.toString();
  }

  private enum Mode {

    DEFAULT, PRINT_RESULT, CALCULATE, EXIT;

    static Mode from(int ordinal) {

      for (Mode mode : Mode.values()) {
        if (mode.ordinal() == ordinal) {
          return mode;
        }
      }

      return DEFAULT;
    }


  }


}
