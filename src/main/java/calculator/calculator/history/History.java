package calculator.calculator.history;

import java.util.Collection;

public interface History {
    void save(String... history);
    Collection<?> findAllHistories();
}
