import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {
    Map<String ,Number> history = new HashMap<>();

    private boolean save(){
        return true;
    }

    List<String> listAll(){
        List<String> historyList = new ArrayList<>();

        for(var entry : history.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();

            String item = key +" = "+ value.toString();
            historyList.add(item);
        }
        return historyList;
    }
}
