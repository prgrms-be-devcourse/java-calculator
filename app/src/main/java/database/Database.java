package database;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Database {
    private Deque<FormulaEntity> database;

    public Database() {
        database = new ArrayDeque<>();
    }

    public String[] findAll() {
        String[] result = new String[database.size()];
        Iterator iter = database.iterator();
        int i = 0;
        while(iter.hasNext()){
            result[i++] = iter.next().toString();
        }
        return result;
    }

    public void add(String formula, double result) {
        database.addFirst(new FormulaEntity(formula,result));
    }
}
