package calculator.engine;


import calculator.exception.DivisionByZero;
import calculator.repository.CalculatorRepository;
import calculator.repository.CalculatorRepositoryMap;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Calculator implements Runnable {
    private final CalculatorRepository repository;
    private final Console console;
    private final Postfix postfix;
    private Stack<Integer> stack;
    private boolean isRunning;

    public Calculator() {
        this.repository = new CalculatorRepositoryMap();
        this.postfix = new Postfix();
        this.console = new Console();
        this.isRunning = true;
    }

    @Override
    public void run() {
        while(isRunning) {
            String input = console.initMessage();
            doAction(input);
        }
    }

    private void doAction(String input) {
        switch(input) {
            case "1":
                console.print(search());
                break;
            case "2":
                calculate(console.input());
                break;
            case "3":
                exit();
                break;
            default:
                console.errorMessage(new IllegalArgumentException());
                break;
        }
    }

    public String search() {
        return repository.search();
    }

    public void calculate(String formula) {
        String answer;
        try {
            List<String> postfixFormula = postfix.makeToPostfix(formula);
            stack = new Stack<>();

            doCalculate(postfixFormula);

            answer = String.valueOf(stack.get(0));
            repository.save(formula, answer);

            console.print(answer + "\n");
        } catch (Exception e) {
            console.errorMessage(e);
            doByException(e);
        }
    }

    private void doByException(Exception e) {
        if(e instanceof DivisionByZero) {
            calculate(console.input());
        } else if(e instanceof IllegalArgumentException) {
            doAction(console.initMessage());
        } else {
            exit(gi
        }
    }

    private void doCalculate(List<String> postfixFormula) throws DivisionByZero {
        for (String s : postfixFormula) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    doOperation(s);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
    }

    private void doOperation(String operator) throws DivisionByZero {
        if(stack.size() >= 2) {
            Integer a = stack.pop();
            Integer b = stack.pop();

            switch (operator) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                case "/":
                    if(a == 0) {
                        throw new DivisionByZero();
                    }

                    stack.push(b / a);
                    break;
                default:
                    break;
            }
        }
    }


    public void exit() {
        console.exitMessage();
        this.isRunning = false;
    }
}
