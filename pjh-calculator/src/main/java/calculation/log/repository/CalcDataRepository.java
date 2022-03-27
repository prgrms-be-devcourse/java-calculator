package calculation.log.repository;

import calculation.model.CalcData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CalcDataRepository implements DataRepository<CalcData, Long> {

  private Long pk;

  private Map<Long, CalcData> store;

  public CalcDataRepository() {
    this.pk = 0L;
    this.store = new LinkedHashMap<>();
  }

  @Override
  public void save(CalcData data) {
    data.setId(pk);
    this.store.put(pk, data);
    this.pk++;
  }

  @Override
  public Optional<CalcData> findById(Long id) {
    return Optional.of(store.get(id));
  }

  @Override
  public List<CalcData> findAll() {
    return new ArrayList<CalcData>(this.store.values());
  }
}

