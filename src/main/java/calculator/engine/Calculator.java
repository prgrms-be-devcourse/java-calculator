package calculator.engine;


import calculator.repository.CalculatorRepository;
import calculator.repository.CalculatorRepositoryMap;

import java.util.List;
import java.util.Stack;

public class Calculator implements Runnable {
    private final CalculatorRepository repository;
    private final Console console;
    private final Postfix postfix;
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
            String input = console.runMessage();
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
                doAction(console.errorMessage());
                break;
        }
    }

    public String search() {
        return repository.search();
    }

    public String calculate(String formula) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        try {
            List<String> strings = postfix.makeToPostfix(formula);
            for(String s : strings) {
                switch(s) {
                    case "+":
                        if (stack.size() >= 2) {
                            Integer a = stack.pop();
                            Integer b = stack.pop();
                            stack.push(a + b);
                        }
                        break;
                    case "-":
                        if (stack.size() >= 2) {
                            Integer a = stack.pop();
                            Integer b = stack.pop();
                            stack.push(b - a);
                        }
                        break;
                    case "*":
                        if (stack.size() >= 2) {
                            Integer a = stack.pop();
                            Integer b = stack.pop();
                            stack.push(a * b);
                        }
                        break;
                    case "/":
                        if (stack.size() >= 2) {
                            Integer a = stack.pop();
                            Integer b = stack.pop();

                            try {
                                if(a == 0) {
                                    throw new Exception("0으로 값을 나눌 수 없습니다.");
                                }

                                stack.push(b / a);
                            } catch(Exception e) {
                                console.print(e.getMessage());
                                calculate(console.input());
                            }
                        }
                        break;
                    case "(":
                    case ")":
                        break;
                    default:
                        stack.push(Integer.parseInt(s));
                        break;
                }
            }
        } catch (IllegalAccessException e) {
            console.print("입력값을 확인해 주세요.");
            calculate(console.input());
        } catch (Exception e) {
            console.print("예상하지 못한 오류가 발생하였습니다.");
            exit();
        }

        String answer = String.valueOf(stack.get(0));
        repository.save(formula, answer);

        sb.append(formula).append("\n").append(answer).append("\n");

        return sb.toString();
    }

    public void exit() {
        console.exitMessage();
        this.isRunning = false;
    }
}
