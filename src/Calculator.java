import java.io.IOException;
import java.util.List;

public interface Calculator {

    void run() throws IOException;

    double calculate(List<String> expression) throws Exception;

}
