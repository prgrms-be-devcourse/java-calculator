package calculation.log.repository;

import calculation.model.CalculationData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CalculationDataRepository implements DataRepository<CalculationData, Long> {

  private Long idSequence;

  private static final Map<Long, CalculationData> store = new LinkedHashMap<>();

  public CalculationDataRepository() {
    this.idSequence = 0L;
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

