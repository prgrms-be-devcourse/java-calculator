package com.programmers.devcourse;

import com.programmers.devcourse.calculator.Calculator;
import com.programmers.devcourse.calculator.ConsoleCalculator;
import com.programmers.devcourse.parser.RegexParser;
import com.programmers.devcourse.processor.StringTokenProcessor;

public class Main {


  public static void main(String[] args) {

    Calculator calculator = new ConsoleCalculator(new RegexParser(), new StringTokenProcessor());

    calculator.start();

  }


}
