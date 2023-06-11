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

        if (results.size() == 0) {
            System.out.println("[ 조회된 계산이력 없음 ]\n");

        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
