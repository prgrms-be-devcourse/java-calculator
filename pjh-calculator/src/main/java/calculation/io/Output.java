package calculation.io;

import calculation.model.CalcData;
import java.io.IOException;

public interface Output {

  void printCommand() throws IOException;

  void printErrorMsg(String errorMsg) throws IOException;

  void printAnswer(CalcData calcData) throws IOException;
}
