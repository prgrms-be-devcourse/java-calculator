package programmers.calculator.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryImpl implements Memory<String, String> {

  private final List<String> memory = new ArrayList<>();

  private final Map<String, String> cache = new HashMap<>();

  @Override
  public void save(String key, String value) {
    cache.put(key, value);
    memory.add(key + " = " + value);
  }

  @Override
  public List<String> findAll() {
    return memory;
  }

  @Override
  public Optional<String> find(String key) {
    return Optional.ofNullable(cache.get(key));
  }
}
