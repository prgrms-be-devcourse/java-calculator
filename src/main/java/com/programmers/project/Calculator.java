package com.programmers.project;

import com.programmers.project.io.Console;
import com.programmers.project.io.Input;
import com.programmers.project.repository.DataRepository;
import com.programmers.project.repository.VolatilityRepository;

import java.time.temporal.ChronoField;
import java.util.*;


public class Calculator extends Basic{

    private Console console = new Console(); //입출력

    private final List<String> operations = new ArrayList<>(Arrays.asList("+","-","*","/"));  // 연산자


    public Queue<String> priority(String s) { // 후위연산식으로 변환
        HashMap<String, Integer> pr = new HashMap<>(); // 우선순위 저장
        pr.put("+", 1);
        pr.put("-", 1);
        pr.put("*", 2);
        pr.put("/", 2);

        Stack<String> stack = new Stack<>();
        String[] parts = s.split(" ");

        Queue<String> result = new LinkedList<>();

        for (int i = 0; i < parts.length; i++) {
            if (i%2 == 0) {  // 숫자라면
                result.offer(parts[i]);
            }

            else { // 연산자라면
                if (!stack.isEmpty() && pr.get(stack.peek()) >= pr.get(parts[i])) { // 스택에 있는 수가 우선순위가 높거나 같을 때
                    result.offer(stack.pop()); // 큐에 넣기
                }
                stack.push(parts[i]);  // 스택에 넣기
            }

        }

        while (!stack.isEmpty()) { // 스택에서 나머지 꺼내서 전부 큐에 넣기
            result.offer(stack.pop());
        }

        return result;
    }




    public double calculate(String s){ // 중위연산식 받아서 계산
        Queue<String> formula = priority(s);
        double result = 0;
        Stack<Double> numbers = new Stack<>();

        for(String str : formula){
            if(!operations.contains(str)) { // 숫자라면
                numbers.push(Double.parseDouble(str));
            }
            else{ // 연산자라면
                Double num2 = numbers.pop();
                Double num1 = numbers.pop();
                numbers.push(cal(num1,num2,str));
            }
        }

        return numbers.pop();
    }
}
