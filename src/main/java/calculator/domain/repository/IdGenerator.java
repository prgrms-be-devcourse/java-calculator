package calculator.domain.repository;

public class IdGenerator {

    private static IdGenerator instance;
    private long idCounter;

    private IdGenerator() {

        idCounter = 0;
    }

    public static IdGenerator getInstance() {

        return instance == null ? instance = new IdGenerator() : instance;
    }

    public synchronized long generateId() {

        return idCounter++;
    }
}

