package calculation.log;

import calculation.model.CalcData;
import calculation.log.repository.DataRepository;
import java.util.List;

public class CalcLogService implements LogService<CalcData> {

  private DataRepository<CalcData, Long> repository;

  public CalcLogService(DataRepository repository) {
    this.repository = repository;
  }

  public void printLogById(Long id) {
    CalcData o = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 데이터 입니다."));
    System.out.println(o.getExpression() + " = " + o.getAns());
  }

  public void log(CalcData data) {
    repository.save(data);
  }

  public void printLog() {
    List<CalcData> data = repository.findAll();
    for (CalcData o : data) {
      System.out.println(o.getExpression() + " = " + o.getAns());
    }
  }
}
