import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History implements IHistory{
    Map<String ,Double> history = new HashMap<>();

    @Override
    public boolean save(String operation, Double result) {
        history.put(operation, result);
        return true;
    }

    public List<String> getList(){
        List<String> historyList = new ArrayList<>();

        for(var entry : history.entrySet()) {
            String operation = entry.getKey();
            Number result = entry.getValue();

            String item = operation + " = " + result.toString();
            historyList.add(item);
        }
        return historyList;
    }

    @Override
    public boolean isExist(String operation) {
        return history.containsKey(operation);
    }

    @Override
    public Double getResult(String operation) {
        return history.get(operation);
    }

    public int count(){
        return history.size();
    }
}
