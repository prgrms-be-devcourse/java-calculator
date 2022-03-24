import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public interface ExpressionConverter {

    /**
     * 입력받은 String expression을 토큰화하여 List<String>으로 반환합니다.
     * @param expression
     * @return
     */
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
