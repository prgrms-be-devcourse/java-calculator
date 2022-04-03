import io.Console;
import model.Calculator;
import model.Expression;
import repository.ExpressionRepository;
import repository.MemoryExpressionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        ExpressionRepository expressionRepository = new MemoryExpressionRepository();

        while(true) {
            int choice = console.choiceInput();
            if(choice == 1) {
                List<Expression> expressions = expressionRepository.findAll();
                console.printAllExpressions(expressions
                        .stream()
                        .map(exp -> exp.getExpression() + " = " + exp.getCalcResult())
                        .collect(Collectors.toList()));
            } else if(choice == 2) {
                String exprInput = console.expressionInput();
                Expression expression = new Expression(exprInput);
                String[] splitExpressions = exprInput.split(" ");
                double calculatedNum = Calculator.calculate(exprInput);
                expressionRepository.save(expression);
                console.printCalculatedNumber(calculatedNum);
            } else {
                console.printChooseWrongNumber();
                break;
            }
        }
    }

}
