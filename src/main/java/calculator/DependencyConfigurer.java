package calculator;

import calculator.model.expression.ExpressionFactory;
import calculator.model.expression.TokenTypeChecker;
import calculator.model.operator.OperatorFactory;
import calculator.model.operator.OperatorFactoryImpl;
import calculator.module.arithmetic.ArithmeticModule;
import calculator.module.arithmetic.StackArithmeticModule;
import calculator.module.history.CalculationHistoryManager;
import calculator.module.history.MemoryCalculationHistoryManager;
import calculator.module.ui.ConsoleUserInterface;
import calculator.module.ui.UserInterface;
import calculator.module.validator.CommonExpressionValidator;
import calculator.module.validator.ExpressionValidator;

/**
* DependencyConfigurer 설명
*   각 클래스들의 의존성을 관리해주는 클래스
**/

public class DependencyConfigurer {
    public Calculator calculator(){
        return new Calculator(calculationHistoryManager(),
                                arithmeticModule(),
                                expressionValidator(),
                                userInterface(),
                                expressionFactory()
        );
    }

    public CalculationHistoryManager calculationHistoryManager(){
        return new MemoryCalculationHistoryManager(userInterface());
    }

    public ArithmeticModule arithmeticModule(){
        return new StackArithmeticModule();
    }

    public ExpressionValidator expressionValidator(){
        return new CommonExpressionValidator();
    }

    public UserInterface userInterface(){
        return new ConsoleUserInterface();
    }

    public OperatorFactory operatorFactory(){
        return new OperatorFactoryImpl();
    }

    public ExpressionFactory expressionFactory(){
        return new ExpressionFactory(tokenClassifier());
    }

    public TokenTypeChecker tokenClassifier(){
        return new TokenTypeChecker(operatorFactory());
    }
}
