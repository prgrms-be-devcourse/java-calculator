package repository;

import io.DisplayMessage;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapRepository implements Repository {
    private int count = 0;
    private static final HashMap<Integer, String> repository = new LinkedHashMap<>();

    @Override
    public void inquiry() {
        System.out.println(DisplayMessage.SPLIT_LINE.getMessage());
        for (Integer integer : repository.keySet()) {
            System.out.println(integer + ". " + repository.get(integer));
        }
        System.out.println(DisplayMessage.SPLIT_LINE.getMessage());
    }
    @Override
    public void save(String record) {
        repository.put(++count, record);
    }

    public int getCount() {
        return count;
    }
}
