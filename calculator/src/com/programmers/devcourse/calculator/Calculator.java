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

  // Enum 클래스를 활용해서 mode를 if 문 없이 사용해보고 싶다.
  // Enum 클래스에는 각 모드마다 메서드가 정해져 있어야 하는 것이 아닐까?
  // 그럴려면 input, output 인터페이스가 정해져 있어야 할 듯


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
    int mode;
    try {
      while (true) {
        mode = input.getMenuSelection();
        if (mode == 1) {
          output.sendAllResults(repository.getAll());
        } else if (mode == 2) {
          handleExpressionFromConsole();

        } else if (mode == 3) {
          break;
        } else {
          output.sendMessage("일치하는 메뉴가 없습니다.");

        }
      }

    } catch (IOException | NumberFormatException e) {

      if (e instanceof IOException) {
        e.printStackTrace();

      }
      output.sendMessage("입력 형식이 적합하지 않습니다.");

    } finally {
      try {
        output.close();
        if (input != output) {
          input.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
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


}
