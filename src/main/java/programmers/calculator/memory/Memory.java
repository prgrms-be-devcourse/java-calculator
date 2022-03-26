package programmers.calculator.memory;

import java.util.List;
import java.util.Optional;

public interface Memory<K, V>{

  void save(K key, V value);

  List<String> findAll();

  Optional<V> find(K key);
}
