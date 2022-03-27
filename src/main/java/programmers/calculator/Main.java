package programmers.calculator;

import programmers.calculator.controller.ControlUnit;
import programmers.calculator.controller.WhiteSpaceParser;
import programmers.calculator.io.Console;
import programmers.calculator.repository.InMemoryRepository;
import programmers.calculator.processor.Processor;
import programmers.calculator.processor.register.BufferRegister;
import programmers.calculator.processor.register.OperatorRegister;
import programmers.calculator.processor.register.ResultRegister;

public class Main {

  public static void main(String[] args) {
    Console console = new Console();
    Processor processor = new Processor(
        new BufferRegister(),
        new ResultRegister(),
        new OperatorRegister());
    ControlUnit controlUnit = new ControlUnit(
        new WhiteSpaceParser()
        , processor,
        new InMemoryRepository());
    Calculator calculator = new Calculator(console, console, controlUnit);
    calculator.run();
  }
}
