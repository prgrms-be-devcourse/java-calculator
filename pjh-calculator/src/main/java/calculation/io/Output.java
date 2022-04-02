package calculation.io;

import calculation.model.CalculationData;
import java.io.IOException;

public interface Output {

  void printCommand() throws IOException;

  void printErrorMsg(String errorMsg) throws IOException;

  void printAnswer(CalculationData calcData) throws IOException;
}
