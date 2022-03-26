package programmers.calculator.processor;


import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import programmers.calculator.processor.arithmetic.Operator;
import programmers.calculator.processor.register.BufferRegister;
import programmers.calculator.processor.register.OperatorRegister;
import programmers.calculator.processor.register.ResultRegister;
import programmers.calculator.util.PatternUtil;

@RequiredArgsConstructor
public class Processor {

  private final BufferRegister bufferRegister;
  private final ResultRegister resultRegister;
  private final OperatorRegister operatorRegister;

  public void writeBuffer(String token) {
    if (PatternUtil.isNumeric(token)) {
      bufferRegister.save(token);
      return;
    }
    Operator operator = Operator.of(token);
    List<String> trailingSymbols = operatorRegister.popTrailingSymbols(operator);
    bufferRegister.saveAll(trailingSymbols);
    operatorRegister.save(operator);
  }

  public List<String> readBuffer() {
    List<String> buffer = new ArrayList<>();
    buffer.addAll(bufferRegister.popAll());
    buffer.addAll(operatorRegister.popAll());
    return buffer;
  }

  public void writeResult(String token) {
    if (PatternUtil.isNumeric(token)) {
      resultRegister.save(Double.parseDouble(token));
      return;
    }
    double operand2 = resultRegister.pop();
    double operand1 = resultRegister.pop();
    resultRegister.save(calculate(operand1, operand2, token));
  }

  public double readResult() {
    return resultRegister.pop();
  }

  private double calculate(double x, double y, String symbol) {
    Operator op = Operator.of(symbol);
    return op.operate(x, y);
  }
}
