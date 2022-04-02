package calculation.log.repository;

import calculation.model.CalculationData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CalcDataRepository implements DataRepository<CalculationData, Long> {

  private Long idSequence;

  private Map<Long, CalculationData> store;

  public CalcDataRepository() {
    this.idSequence = 0L;
    this.store = new LinkedHashMap<>();
  }

  @Override
  public void save(CalculationData data) {
    data.setId(idSequence);
    this.store.put(idSequence, data);
    this.idSequence++;
  }

  @Override
  public Optional<CalculationData> findById(Long id) {
    return Optional.of(store.get(id));
  }

  @Override
  public List<CalculationData> findAll() {
    return new ArrayList<CalculationData>(this.store.values());
  }
}

