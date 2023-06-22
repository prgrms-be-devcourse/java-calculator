package calulator.repository;

import java.util.List;

public interface ExpressionRepository {

    void addExpressionAndResult(String expression, String result);

    List<String> resultsToList();
}
