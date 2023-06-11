import java.util.*;

public class ResultSaveService implements CalculatorFunction {

    String name;
    LinkedHashMap<Integer, Result> results = new LinkedHashMap<>();

    public ResultSaveService(String name) {
        this.name = name;
    }

    @Override
    public void doService(Calculator calculator) {
        System.out.println("ResultSaveService.doService");

        if (results.size() == 0) {
            System.out.println("[ 조회된 계산이력 없음 ]\n");
        } else {
            StringBuilder savedResults = new StringBuilder();
            Iterator<Integer> iterator = results.keySet().iterator();

            while(iterator.hasNext()) {
                Result result = results.get(iterator.next());
                savedResults.append(result.fullEquation());
            }
            System.out.println(savedResults);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void save(Result result) {
        results.put(results.size() + 1, result);
    }
}
