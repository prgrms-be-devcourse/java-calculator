package org.programmers.service;

import lombok.AllArgsConstructor;
import org.programmers.entity.ResultModel;
import org.programmers.repository.Repository;

import java.util.*;

/**
 * 기존에 연산과 저장을 동시에 했던 calculateSave 메소드를
 * calculate와 historysave 메소드로 분리했습니다.
 * 그리고 historysave메소드는 반환값을 줘서 저장한 값을 확인할 수 있도록 했습니다.
 *
 */
@AllArgsConstructor
public class CalculateService {
    private Repository calculatorRepository;

    public double calculateResult(String expression) {
        return calculate(makePostfix(expression));
    }

    public ResultModel historySave(double result, String expression){
        return calculatorRepository.save(new ResultModel(expression, result));
    }

    public List<ResultModel> findHistory() {
        Map<Long, ResultModel> map = calculatorRepository.findAll();

        List<Map.Entry<Long, ResultModel>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        List<ResultModel> result = new ArrayList<>();
        entries.forEach((i)-> result.add(i.getValue()));

        return result;
    }

    private Deque<String> makePostfix(String expression) {
        StringTokenizer st = new StringTokenizer(expression);
        Deque<String> deque = new ArrayDeque<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (isNumeric(token)) {
                deque.addLast(token);
            } else {
                if (isNumeric(deque.peekFirst())) {
                    deque.addFirst(token);

                } else if (!deque.isEmpty() && token.equals("*")
                        || !deque.isEmpty() && token.equals("/")){
                    deque.addFirst(token);
                }
                else {
                    deque.addLast(deque.removeFirst());
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
