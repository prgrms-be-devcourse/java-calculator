package com.programmers.devcourse.calculator;

import com.programmers.devcourse.exception.CalculatorException;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.processor.Processor;
import com.programmers.devcourse.repository.ResultRepository;
import com.programmers.devcourse.repository.StringResultRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map.Entry;

public class ConsoleCalculator implements Calculator {

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
    double result;
    try {

      Entry<String, Double> resultEntry = formatAndCalculateExpression(expression);
      expression = resultEntry.getKey();
      result = resultEntry.getValue();

    } catch (CalculatorException e) {

      System.out.println(e.getMessage());
      System.out.println();
      return;

    }

    repository.save(
        expression, result);
    System.out.println(result + "\n");
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
    repository.getAllResults().forEach((key, value) -> {
      System.out.println(key + " = " + value);
    });

    System.out.println();
  }


  private Entry<String, Double> formatAndCalculateExpression(String expression)
      throws CalculatorException {
    List<String> tokens;
    tokens = parser.parse(expression);
    String formattedExpression = mapTokensToFormattedExpression(tokens);
    double result = processor.process(tokens);

    return new Entry<String, Double>() {
      @Override
      public String getKey() {
        return formattedExpression;
      }

      @Override
      public Double getValue() {
        return result;
      }

      @Override
      public Double setValue(Double value) {
        throw new UnsupportedOperationException();
      }
    };
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
