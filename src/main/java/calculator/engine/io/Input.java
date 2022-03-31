package calculator.engine.io;

import java.util.StringTokenizer;

public interface Input {
    // 옵션 입력 (1. 조회, 2. 계산)
    String input(String s);

    // 계산식 parser
    static String[] parse(String s) {
        // 공백 제거
        String str = s.replace(" ", "");

        // 문자열 자르기
        StringTokenizer st = new StringTokenizer(str, "\\+-\\*/\\(\\)", true);
        String[] result = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            result[i++] = st.nextToken();
        }

        return result;
    }
}

