package org.programmers.calculator.configuration;

import org.programmers.calculator.Menu;
import org.programmers.calculator.postfixCalculator.NumeralCalculator;
import org.programmers.calculator.postfixCalculator.NumeralPrefixSolver;
import org.programmers.calculator.postfixCalculator.Solver;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;
import org.programmers.calculator.postfixParser.PostfixParser;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.TypeChecker.TypeChecker;
import org.programmers.calculator.repository.MemoryMapRepository;
import org.programmers.calculator.repository.Repository;

public final class ObjectContainer {

    private static PostfixParser parser;
    private static TypeChecker typeChecker;
    private static Solver solver;
    private static NumeralCalculator calculator;
    private static Repository repository;
    private static Menu menu;

    private ObjectContainer() {
    }

    public static void create(Operand operand) {
        destroy();
        if (operand==Operand.RATIONAL_NUMBER) {
            repository = new MemoryMapRepository();
            typeChecker = new NumeralTypeChecker();
            parser = new NumeralPostfixParser(typeChecker);
            calculator = new NumeralCalculator(typeChecker);
            solver = new NumeralPrefixSolver(typeChecker, calculator);
            menu = new Menu(parser, solver, repository);
        }
    }

    public static PostfixParser getParser() {
        return parser;
    }

    public static Solver getSolver() {
        return solver;
    }

    public static Menu getMenu() {
        return menu;
    }

    private static void destroy() {
        typeChecker = null;
        parser = null;
        calculator = null;
        solver = null;
        menu = null;
    }
}
