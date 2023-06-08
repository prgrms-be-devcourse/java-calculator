package calculator.domain.repository;

public class IdGenerator {

    private long idCounter;

    private IdGenerator() {
    }

    private static class IdGeneratorHolder {

        private static final IdGenerator INSTANCE = new IdGenerator();
    }

    public static IdGenerator getInstance() {

        return IdGeneratorHolder.INSTANCE;
    }

    public synchronized long generateId() {

        return ++idCounter;
    }
}

