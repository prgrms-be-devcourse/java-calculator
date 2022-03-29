package org.programmers.calculator.configuration;

import org.programmers.calculator.postfixCalculator.NumeralCalculator;
import org.programmers.calculator.postfixCalculator.NumeralPrefixSolver;
import org.programmers.calculator.postfixCalculator.Solver;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;
import org.programmers.calculator.postfixParser.PostfixParser;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.TypeChecker.TypeChecker;

public class ObjectContainer {

    private static PostfixParser parser;
    private static TypeChecker typeChecker;
    private static Solver solver;
    private static NumeralCalculator calculator;

    public void create(Operand operand) {
        if (operand==Operand.RATIONAL_NUMBER) {
            typeChecker = new NumeralTypeChecker();
            parser = new NumeralPostfixParser(typeChecker);
            calculator = new NumeralCalculator(typeChecker);
            solver = new NumeralPrefixSolver(typeChecker, calculator);
        }
    }

    public static PostfixParser getParser() {
        return parser;
    }

    public static Solver getSolver() {
        return solver;
    }
}
