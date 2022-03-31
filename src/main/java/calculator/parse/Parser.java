package calculator.parse;

import java.util.ArrayList;

public interface Parser {
    ArrayList<String> parse(String exp);

    boolean validCheck(ArrayList<String> exp);

}
