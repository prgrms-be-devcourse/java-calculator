package hyuk.model;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private List<Integer> operands;

    public Operands(String exp) {
        operands = new ArrayList<>();

        String[] tokens = exp.split(" ");
        for (String token : tokens) {
            if (token.chars().allMatch(Character::isDigit)) {
                operands.add(Integer.parseInt(token));
            }
        }
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
