import org.junit.jupiter.api.Test;
import save.SaveWithMap;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveWithMapTest {

    @Test
    public void testMapSaving(){
        String string = "1+2*3";
        Float result = 7.0F;
        SaveWithMap saveWithMap = new SaveWithMap();
        saveWithMap.saveAtMap(string, result);

        assertEquals(getRightMap(string,result), saveWithMap.getResultMap());

    }

    public Map<String,Float> getRightMap(String string, Float result){
        Map<String,Float> resultMap = new HashMap<>();
        resultMap.put(string, result);

        return resultMap;
    }
}
