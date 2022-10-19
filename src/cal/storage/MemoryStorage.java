package src.cal.storage;

import java.util.ArrayList;

public class MemoryStorage implements Storage {
    ArrayList<String> calResultList = new ArrayList<>();

    public void add(String expression, double calResult) {
        calResultList.add(expression + "=" + calResult);
    }

    public ArrayList<String> getAll() {
        return calResultList;
    }
}
