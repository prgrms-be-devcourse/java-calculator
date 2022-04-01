package src.cal.storage;

import java.util.ArrayList;

public interface Storage {
    void add(String expression, double calResult);
    ArrayList<String> getAll();
}
