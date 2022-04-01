package save;

import java.util.HashMap;
import java.util.Map;

public class SaveWithMap {
    private Map<String, Float> resultMap;

    public SaveWithMap(){
        resultMap = new HashMap<>();
    }

    public void saveAtMap(String string, Float result){
        resultMap.put(string,result);
    }

    public Map<String,Float> getResultMap(){
        return resultMap;
    }
}
