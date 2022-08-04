package org.programmers.calculator.configuration;

import org.programmers.calculator.Menu;
import org.programmers.calculator.TypeChecker.BooleanTypeChecker;
import org.programmers.calculator.postfixCalculator.*;
import org.programmers.calculator.postfixParser.BooleanPostfixParser;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;
import org.programmers.calculator.postfixParser.PostfixParser;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.TypeChecker.TypeChecker;
import org.programmers.calculator.repository.MemoryMapRepository;
import org.programmers.calculator.repository.Repository;

public final class ObjectContainer {

    private static PostfixParser parser;
    private static TypeChecker typeChecker;
    private static PostfixSolver solver;
    private static Repository repository;
    private static Menu menu;

    private ObjectContainer() {
    }

    public static void create(Operand operand) {
        destroy();

        if (operand==Operand.RATIONAL_NUMBER) {
            typeChecker = new NumeralTypeChecker();
            parser = new NumeralPostfixParser(typeChecker);
            solver = new NumeralPostfixSolver(typeChecker);
        }
        else if (operand==Operand.BOOLEAN) {
            typeChecker = new BooleanTypeChecker();
            parser = new BooleanPostfixParser(typeChecker);
            solver = new BooleanPostfixSolver(typeChecker);
        }

        repository = new MemoryMapRepository();
        menu = new Menu(parser, solver, repository);

    }

    public static PostfixParser getParser() {
        return parser;
    }

    public static PostfixSolver getSolver() {
        return solver;
    }

    public static Menu getMenu() {
        return menu;
    }

    private static void destroy() {
        typeChecker = null;
        parser = null;
        solver = null;
        menu = null;
    }
}
