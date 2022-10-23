package calculator.repository;

import java.util.List;

public interface Repository {

    void save(String formula, String answer);

    String find(String formula);

    boolean isExist(String formula);

    List<String> findAll();

}
