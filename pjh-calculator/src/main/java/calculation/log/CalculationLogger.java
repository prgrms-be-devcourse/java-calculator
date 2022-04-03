package calculation.log;

import calculation.log.repository.DataRepository;
import calculation.model.CalculationData;
import java.util.List;

public class CalculationLogger implements Logger<CalculationData> {

  private DataRepository<CalculationData, Long> repository;

  public CalculationLogger(DataRepository repository) {
    this.repository = repository;
  }

  @Override
  public void printLogById(Long id) {
    CalculationData foundData = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 데이터 입니다."));
    System.out.println(foundData.getExpression() + " = " + foundData.getAnswer());
  }

  @Override
  public void log(CalculationData data) {
    repository.save(data);
  }

  @Override
  public void printLog() {
    List<CalculationData> foundDataList = repository.findAll();
    for (CalculationData data : foundDataList) {
      System.out.println(data.getExpression() + " = " + data.getAnswer());
    }
  }
}
