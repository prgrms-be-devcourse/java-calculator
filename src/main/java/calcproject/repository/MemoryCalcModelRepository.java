package calcproject.repository;

import calcproject.models.CalcModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryCalcModelRepository implements CalcModelRepository{

    private Map<Integer, CalcModel> calcMap;
    private int lastIdx;
    public MemoryCalcModelRepository() {
        calcMap = new HashMap<>();
        lastIdx = 0;
    }

    @Override
    public void SaveCalcModel(CalcModel calcModel) {
        calcMap.put(lastIdx, calcModel);
        lastIdx += 1;
    }

    @Override
    public Collection<CalcModel> LoadCalcModels() {
        Collection<CalcModel> calcModels = calcMap.values();
        return calcModels;
    }
}
