package calculation.log.repository;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> {

  Optional<T> findById(Long id);

  List<T> findAll();

  void save(T data);
}
