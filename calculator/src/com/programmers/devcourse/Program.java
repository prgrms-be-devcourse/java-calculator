package com.programmers.devcourse;

import com.programmers.devcourse.calculator.Calculator;
import com.programmers.devcourse.calculator.ConsoleCalculator;
import com.programmers.devcourse.parser.RegexParser;
import java.io.IOException;

public class Program {


  public static void main(String[] args) throws IOException {

    Calculator calculator = new ConsoleCalculator(new RegexParser());

    calculator.start();

  }


}
