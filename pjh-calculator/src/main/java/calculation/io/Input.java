package calculation.io;

import java.io.IOException;

public interface Input {

  int inputCommandType(String prompt) throws IOException;

  String input() throws IOException;
}
