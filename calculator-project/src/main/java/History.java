import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {
    Map<String ,Number> history = new HashMap<>();

    boolean save(String operation, Number result){
        history.put(operation, result);
        return true;
    }

    List<String> getList(){
        List<String> historyList = new ArrayList<>();
        System.out.println("list All");

        for(var entry : history.entrySet()) {
            String operation = entry.getKey();
            Number result = entry.getValue();

            String item = operation + " = " + result.toString();
            historyList.add(item);
        }

        return historyList;
    }

    int count(){
        return history.size();
    }
}
