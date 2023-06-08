package calcproject.repository;
import calcproject.models.CalcModel;

import java.util.Collection;
public interface CalcModelRepository {
    void SaveCalcModel(CalcModel calcModel);
    Collection<CalcModel> LoadCalcModels();
}
