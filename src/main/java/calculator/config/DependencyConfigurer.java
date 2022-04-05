package calculator.config;

import calculator.CalculationProcessor;
import calculator.Calculator;
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
 * 각 클래스들의 의존성을 설정하고 설정된 의존성에 맞추어 객체를 생성해주는 클래스
 **/

public class DependencyConfigurer {
    public Calculator createCalculatorWithDependency() {
        return new Calculator(createUserInterfaceWithDependency(),
                createCalculationHistoryManagerWithDependency(),
                createCalculationProcessorWithDependency()
        );
    }

    public CalculationHistoryManager createCalculationHistoryManagerWithDependency() {
        return new MemoryCalculationHistoryManager(createUserInterfaceWithDependency());
    }

    public CalculationProcessor createCalculationProcessorWithDependency() {
        return new CalculationProcessor(createCalculationHistoryManagerWithDependency(),
                createArithmeticModuleWithDependency(),
                createUserInterfaceWithDependency(),
                createExpressionValidatorWithDependency(),
                createExpressionFactoryWithDependency()
        );
    }

    public ArithmeticModule createArithmeticModuleWithDependency() {
        return new StackArithmeticModule();
    }

    public ExpressionValidator createExpressionValidatorWithDependency() {
        return new CommonExpressionValidator();
    }

    public UserInterface createUserInterfaceWithDependency() {
        return new ConsoleUserInterface();
    }

    public OperatorFactory createOperatorFactoryWithDependency() {
        return new OperatorFactoryImpl();
    }

    public ExpressionFactory createExpressionFactoryWithDependency() {
        return new ExpressionFactory(createTokenClassifierWithDependency());
    }

    public TokenTypeChecker createTokenClassifierWithDependency() {
        return new TokenTypeChecker(createOperatorFactoryWithDependency());
    }
}
