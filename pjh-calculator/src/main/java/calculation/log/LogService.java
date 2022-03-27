package calculation.log;

public interface LogService<T> {

  void log(T exp);

  void printLogById(Long id);

  void printLog();
}
