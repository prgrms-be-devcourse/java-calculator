package calculator.engine.Repository;

import java.util.LinkedHashMap;

public class Memorizer {
    private Integer startNumber = 0;
    private final LinkedHashMap<Integer, String> memoroizer = new LinkedHashMap<>();
    public void storeHistory(String initCalculator) {
        this.memoroizer.put(startNumber++, initCalculator);
    }
    public LinkedHashMap<Integer,String> getMemoroizer(){
        return memoroizer;
    }
}
