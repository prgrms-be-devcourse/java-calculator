package com.programmers.devcourse.calculator;

import com.programmers.devcourse.exception.CalculatorException;
import com.programmers.devcourse.model.Result;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.processor.Processor;
import com.programmers.devcourse.repository.ResultRepository;
import com.programmers.devcourse.repository.StringResultRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleCalculator implements Calculator {

  // Enum 클래스를 활용해서 mode를 if 문 없이 사용해보고 싶다.
  // Enum 클래스에는 각 모드마다 메서드가 정해져 있어야 하는 것이 아닐까?
  // 그럴려면 input, output 인터페이스가 정해져 있어야 할 듯


  private final Parser parser;
  private final BufferedReader br;
  private final ResultRepository<String, Double> repository;
  private final Processor<List<String>, Double> processor;

  public ConsoleCalculator(Parser parser, Processor<List<String>, Double> processor) {
    this.parser = parser;
    this.repository = new StringResultRepository();
    this.br = new BufferedReader(new InputStreamReader(System.in));
    this.processor = processor;
  }

  @Override
  public void start() {
    int mode;
    try {
      while (true) {
        mode = printMenuAndGetMode();
        if (mode == 1) {
          printAllResults();
        } else if (mode == 2) {
          handleExpressionFromConsole();
        } else {
          System.out.println("일치하는 메뉴가 없습니다.");
          break;
        }
      }

    } catch (IOException | NumberFormatException e) {

      if (e instanceof IOException) {
        e.printStackTrace();

      }
      System.out.println("입력 형식이 적합하지 않습니다.");

    } finally {
      try {
        br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      System.out.println("계산기 종료");
    }


  }

  private void handleExpressionFromConsole() throws IOException {
    String expression = br.readLine();
    Result<String, Double> result;
    try {

      result = formatAndCalculateExpression(expression);

    } catch (CalculatorException e) {

      System.out.println(e.getMessage());
      System.out.println();
      return;

    }

    repository.save(result.getKey(), result.getValue());
    System.out.println(result.getValue() + "\n");
  }

  private int printMenuAndGetMode() throws IOException {
    System.out.println("1. 조회");
    System.out.println("2. 계산\n");
    System.out.print("선택 : ");
    int mode = Integer.parseInt(br.readLine());
    System.out.println();
    return mode;
  }

  private void printAllResults() {
    if (repository.getSize() == 0) {
      System.out.println("\n없음");
      return;
    }

    repository.forEach((key, value) -> {
      System.out.println(key + " = " + value);
    });

    System.out.println();
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
