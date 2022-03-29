import java.io.IOException;
import java.util.List;

public interface Calculator {

    void run() throws IOException;

    void printHistory();

    String operate(String expression);

    double calculate(List<String> expression) throws Exception;

}
