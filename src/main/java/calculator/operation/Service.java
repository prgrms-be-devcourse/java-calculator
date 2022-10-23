package calculator.operation;

import java.util.List;

public interface Service {

    String calculate(List<String> postFix);

    List<String> toPostFix(List<String> tokens);

}
