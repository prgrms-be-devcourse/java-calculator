import exception.CalculatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public interface ExpressionConverter {

    default List<String> expressionToList(String expression) {
        List<String> expressionList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "+-/*() ", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals(" ")) continue;
            expressionList.add(token);
        }

        return expressionList;
    }

    void validate(List<String> expressionList);

    List<String> convert(String expression);

}
