package app.calculator;

import java.util.List;

public interface PostfixMaker {
    List<String> makePostfix(Expression expression);
}
