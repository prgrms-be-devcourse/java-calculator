package calculator.engine;


import calculator.exception.DivisionByZero;
import calculator.repository.CalculatorRepository;
import calculator.repository.CalculatorRepositoryMap;

import java.util.List;
import java.util.Stack;

public class Calculator implements Runnable {
    private final CalculatorRepository repository;
    private final Console console;
    private final Postfix postfix;
    private static Stack<Integer> stack;
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
                console.print(calculate(console.input()));
                break;
            case "3":
                exit();
                break;
            default:
                console.illegalExceptionMessage();
                console.print(console.initMessage());
                break;
        }
    }

    public String search() {
        return repository.search();
    }

    public String calculate(String formula) {
        String answer = "";
        try {
            List<String> postfixFormula = postfix.makeToPostfix(formula);

            stack = new Stack<>();

            doCalculate(postfixFormula);

            answer = String.valueOf(stack.get(0));
            repository.save(formula, answer);
        } catch (IllegalAccessException e) {
            console.illegalExceptionMessage();
        } catch (Exception e) {
            console.exceptionMessage();
            exit();
        }

        return answer;
    }

    private void doCalculate(List<String> postfixFormula) {
        for (String s : postfixFormula) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    try {
                        doOperation(s);
                    } catch (DivisionByZero divisionByZero) {
                        console.divisionByZero();
                        calculate(console.input());
                    } catch (Exception e) {
                        exit();
                    }
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
