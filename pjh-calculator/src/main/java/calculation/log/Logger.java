package calculation.log;

public interface Logger<T> {

  void log(T exp);

  void printLogById(Long id);

  void printLog();
}
