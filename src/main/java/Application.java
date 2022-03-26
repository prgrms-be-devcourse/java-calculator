import io.Console;
import model.Expression;
import repository.MemoryExpressionRepository;
import service.ExpressionService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        ExpressionService expressionService = new ExpressionService(new MemoryExpressionRepository());

        while(true) {
            int choice = console.choiceInput();
            if(choice == 1) {
                List<Expression> expressions = expressionService.findAllExpression();
                console.printAllExpressions(expressions
                        .stream()
                        .map(exp -> exp.getExpression() + " = " + exp.getCalcResult())
                        .collect(Collectors.toList()));
            } else if(choice == 2) {
                String exprInput = console.expressionInput();
                double calculatedNum = expressionService.calculateExpression(exprInput);
                console.printCalculatedNumber(calculatedNum);
            } else {
                console.printChooseWrongNumber();
                break;
            }
        }
    }

}
