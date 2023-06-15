package Domain.Execution;

import Common.Exception.DivideByZeroException;
import Common.IO.console.Console;
import Domain.Expression.Expression;
import Domain.Expression.ExpressionRepository;
import Domain.Expression.SolvedExpression;

public class Calculate implements Execution {
    ExpressionRepository repository = new ExpressionRepository();

    @Override
    public boolean execute() {
        Expression exp;
        try {
            exp = new Expression(Console.input.getExpression());
        } catch (RuntimeException e) {
            return false;
        }
        SolvedExpression solved;
        try {
            solved = exp.solve();
        } catch (DivideByZeroException e) {
            return false;
        }
        repository.push(solved);
        Console.output.printNumber(solved.getResult());
        return true;
    }
}
