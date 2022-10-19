package calculator.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryImpl implements Repository{

    private static Map<Integer,String> database = new HashMap<>();
    private static AtomicInteger id = new AtomicInteger(1);

    @Override
    public void save(String s) {
        database.put(id.getAndIncrement(),s);
        System.out.println(s);
    }


    @Override
    public boolean isEmpty() {
        if(database.isEmpty()) return true;
        return false;
    }

    @Override
    public void findAll() {
        database.forEach((i,str) -> System.out.println(i + "번째 계산 >> " + str));
    }
}
