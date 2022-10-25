package com.programmers.calculation;

import static com.programmers.calculation.operation.Operation.ADD;
import static com.programmers.calculation.operation.Operation.DIVISION;
import static com.programmers.calculation.operation.Operation.MULTI;
import static com.programmers.calculation.operation.Operation.SUBTRACT;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

  private final FourArithmetic arithmetic;

  public Calculation(FourArithmetic arithmetic) {
    this.arithmetic = arithmetic;
  }

  public List<String> toList(String[] input) {
    return new ArrayList<>(List.of(input));
  }

  public String calculate(List<String> calculationForm) {
    int index = 0;

    String operInForm;
    while (index < calculationForm.size()) {
      operInForm = calculationForm.get(index);

      if (MULTI.compare(operInForm)) {
        calculationForm.set(index - 1, arithmetic.multi(calculationForm, index));
        deleteCalculated(calculationForm, index);
        index = 0;
      }

      if (DIVISION.compare(operInForm)) {
        if (calculationForm.get(index + 1).equals("0")) {
          return "0으로는 나눌 수 없습니다";
        }
        calculationForm.set(index - 1, arithmetic.division(calculationForm, index));
        deleteCalculated(calculationForm, index);
        index = 0;
      }
      index++;
    }

    index = 0;

    while (index < calculationForm.size()) {
      operInForm = calculationForm.get(index);

      if (ADD.compare(operInForm)) {
        calculationForm.set(index - 1, arithmetic.add(calculationForm, index));
        deleteCalculated(calculationForm, index);
        index = 0;
      }
      if (SUBTRACT.compare(operInForm)) {
        calculationForm.set(index - 1, arithmetic.subject(calculationForm, index));
        deleteCalculated(calculationForm, index);
        index = 0;
      }
      index++;
    }
    return calculationForm.get(0);
  }

  private void deleteCalculated(List<String> cal, int index) {
    cal.remove(index);
    cal.remove(index);
  }

}
