package com.programmers.devcourse;

import com.programmers.devcourse.calculator.Calculator;
import com.programmers.devcourse.parser.Parser;
import com.programmers.devcourse.parser.RegexParser;
import com.programmers.devcourse.processor.Processor;
import com.programmers.devcourse.processor.StringTokenProcessor;
import com.programmers.devcourse.repository.ResultRepository;
import com.programmers.devcourse.repository.StringResultRepository;
import java.util.List;

public class Main {


  public static void main(String[] args) {
    Console console = new Console();
    ResultRepository<String, Double> repository = new StringResultRepository();
    Parser parser = new RegexParser();
    Processor<List<String>, Double> processor = new StringTokenProcessor();

    Calculator calculator = new Calculator(parser, processor, console,
        console, repository);
    
    calculator.start();

  }


}
