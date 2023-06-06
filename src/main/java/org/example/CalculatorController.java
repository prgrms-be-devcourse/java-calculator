package org.example;

import org.example.io.Input;
import org.example.io.Output;
import org.example.calculator.Calculator;

public class CalculatorController {
  Input input;
  Output output;
  Calculator calculator;

  public CalculatorController(Input input, Output output, Calculator calculator) {
    this.input = input;
    this.output = output;
    this.calculator = calculator;
  }
}