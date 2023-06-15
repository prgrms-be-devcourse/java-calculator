package Domain.Expression;

import Common.IO.console.Console;

import java.util.HashMap;
import java.util.Map;

public class ExpressionRepository implements Repository<SolvedExpression> {
    private static int id = 0;
    private static final Map<Integer, SolvedExpression> repository = new HashMap<>();

    @Override
    public void push(SolvedExpression solved) {
        repository.put(id++, solved);
    }

    @Override
    public void printAll() {
        for (int i = 0; i < id; i++) {
            SolvedExpression solved = repository.get(i);
            Console.output.println(solved.getExp() + " = " + solved.getResult());
        }
    }
}
