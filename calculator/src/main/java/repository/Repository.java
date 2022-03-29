package repository;

import java.util.List;
import java.util.Map;

public abstract class Repository<ID,T>{

    protected Map<ID, T> storage;
    protected ID id;

    protected Repository(Map<ID, T> storage, ID id) {
        this.storage = storage;
        this.id = id;
    }

    public abstract T save(String input, double result);
    public abstract List<T> findAll();

}
