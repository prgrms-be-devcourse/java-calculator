package calculation.log;

import calculation.log.repository.DataRepository;
import calculation.model.CalcData;
import java.util.List;

public class CalcLogService implements LogService<CalcData> {

  private DataRepository<CalcData, Long> repository;

  public CalcLogService(DataRepository repository) {
    this.repository = repository;
  }

  public void printLogById(Long id) {
    CalcData foundData = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 데이터 입니다."));
    System.out.println(foundData.getExpression() + " = " + foundData.getAns());
  }

  public void log(CalcData data) {
    repository.save(data);
  }

  public void printLog() {
    List<CalcData> foundDataList = repository.findAll();
    for (CalcData data : foundDataList) {
      System.out.println(data.getExpression() + " = " + data.getAns());
    }
  }
}
