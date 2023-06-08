package main.java.repository;

import java.util.LinkedList;
import java.util.Queue;

public class Memorizer {

    private static Memorizer memorizer = new Memorizer();

    private Queue<String> history;
    private Memorizer() {
        this.history = new LinkedList<>();
    }

    public static Memorizer getInstance() {
        return memorizer;
    }

    public void save(String result) {
        history.add(result);
    }


}
