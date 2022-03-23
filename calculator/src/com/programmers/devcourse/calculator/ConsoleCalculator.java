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

public class ConsoleCalculator implements Calculator {

  private Parser parser;
  private BufferedReader br;
  private ResultRepository<String> repository;
  private Processor<List<String>, Double> processor;


  public ConsoleCalculator(Parser parser, Processor processor) {
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

          String expression = br.readLine();
          double result;
          try {

            result = calculate(expression);

          } catch (CalculatorException e) {

            System.out.println(e.getMessage());
            continue;

          }

          repository.save(
              expression + " = " + result);
          System.out.println(result);
          System.out.println();

        } else {
          break;
        }

      }
      br.close();
    } catch (IOException | NumberFormatException e) {
      
      if (e instanceof IOException) {
        e.printStackTrace();

      }
      System.out.println("1 또는 2를 입력해야 합니다.");


    } finally {
      System.out.println("\n계산기 종료");
    }


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
      System.out.println("없음");
      return;
    }
    for (String result : repository.getAllResults()
    ) {
      System.out.println(result);
    }
    System.out.println();
  }


  private Double calculate(String expression) throws CalculatorException {
    List<String> tokens;
    tokens = parser.parse(expression);

    return processor.process(tokens);
  }


}
