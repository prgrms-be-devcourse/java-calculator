package calculation.calculator.engine;

import calculation.model.CalcData;

public interface Calculator {

  CalcData execute(String exp);
}
