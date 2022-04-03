package calculation.log.repository;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> {

  Optional<T> findById(ID id);

  List<T> findAll();

  void save(T data);
}
