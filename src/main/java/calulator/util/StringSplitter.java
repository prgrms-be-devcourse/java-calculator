package calulator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String SPLIT_REGEX = "\\d+|[-+*/]";

    public static List<String> splitByOperator(String expression) {
        Pattern pattern = Pattern.compile(SPLIT_REGEX);
        Matcher matcher = pattern.matcher(expression);

        List<String> expressions = new ArrayList<>();
        while (matcher.find()) {
            expressions.add(matcher.group());
        }

        return expressions;
    }

}
