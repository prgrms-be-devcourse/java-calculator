package programmers.calculator.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<K, V>{

  void save(K key, V value);

  List<String> findAll();

  Optional<V> find(K key);
}
