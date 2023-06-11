import java.util.HashMap;
import java.util.Map;

public class ResultSaveService implements CalculatorFunction {

    String name;
    Map<Integer, Object> results = new HashMap<>();

    public ResultSaveService(String name) {
        this.name = name;
    }

    @Override
    public void doService() {
        System.out.println("ResultSaveService.doService");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
