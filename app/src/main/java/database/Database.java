package database;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Database {
    private Deque<FormulaEntity> database;

    public Database() {
        database = new ArrayDeque<>();
    }

    public FormulaEntity[] findAll() {
        return (FormulaEntity[])database.toArray();
    }

    public void add(String formula, double result) {
        database.addFirst(new FormulaEntity(formula,result));
    }
}
