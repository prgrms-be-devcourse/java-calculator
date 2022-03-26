package org.programmers.service;

import org.programmers.entity.ResultModel;
import org.programmers.repository.CalculatorRepository;
import org.programmers.repository.Repository;

import java.util.*;

public class CalculateService {
    Repository calculatorRepository = new CalculatorRepository();

    public double calculateSave(String inputEx) {
        Deque<String> deque = makePostfix(inputEx);

        double result = calculate(deque);
        calculatorRepository.save(inputEx, result);
        return result;
    }

    public List<ResultModel> findHistory() {
        Map<Long, ResultModel> map = calculatorRepository.findAll();

        List<Map.Entry<Long, ResultModel>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        List<ResultModel> result = new ArrayList<>();
        entries.forEach((i)-> result.add(i.getValue()));

        return result;
    }

    private Deque<String> makePostfix(String inputEx) {
        StringTokenizer st = new StringTokenizer(inputEx);
        Deque<String> deque = new ArrayDeque<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (isNumeric(token)) {
                deque.addLast(token);
            } else {
                if (isNumeric(deque.peekFirst())) {
                    deque.addFirst(token);

                } else if (!deque.isEmpty() && deque.peekFirst().equals("*")
                        || !deque.isEmpty() && deque.peekFirst().equals("/")) {

                    deque.addLast(deque.removeFirst());
                    deque.addFirst(token);

                } else {
                    deque.addFirst(token);
                }
            }
        }

        while (!deque.isEmpty() && !isNumeric(deque.peekFirst())) {
            deque.addLast(deque.removeFirst());
        }
        return deque;
    }

    private double calculate(Deque<String> deque) {
        Stack<Double> stack = new Stack<>();

        while (!deque.isEmpty()) {
            if (isNumeric(deque.peekFirst())) {
                stack.push(Double.parseDouble(deque.removeFirst()));

            } else {
                switch (deque.removeFirst()) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        double temp = stack.pop();
                        stack.push(stack.pop() - temp);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        temp = stack.pop();
                        stack.push(stack.pop() / temp);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
