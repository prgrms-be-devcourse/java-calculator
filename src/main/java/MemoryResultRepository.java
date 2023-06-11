import model.Result;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class MemoryResultRepository implements Repository {

    List<Result> list = new ArrayList<>();

    @Override
    public void save(Result result) {
        list.add(result);
    }

    @Override
    public List<Result> findAll() {
        return new ArrayList<>(list);
    }
}
