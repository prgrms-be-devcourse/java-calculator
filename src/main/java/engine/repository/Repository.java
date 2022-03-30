package engine.repository;

import java.util.List;

public interface Repository<K,V> {

    void save(V value);

    List<String> findAllValues();

}
