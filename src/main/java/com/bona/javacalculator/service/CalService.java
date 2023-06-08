package com.bona.javacalculator.service;

import com.bona.javacalculator.model.InputAndAnswer;
import com.bona.javacalculator.repository.CalMemoryRepository;
import com.bona.javacalculator.repository.MemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;

@Service
public class CalService {

    MemoryRepository memoryRepository = new CalMemoryRepository();

    public double calculateStr(String input) {
        //숫자만 저장
        Stack<Integer> numbers = new Stack<>();
        char arr[] = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(Character.isDigit(arr[i]) == true){
                numbers.push(Integer.parseInt(String.valueOf(arr[i])));
            }else{
                Integer num1 = numbers.pop();
                Integer num2 = numbers.pop();
                calculateReal(num1, num2, String.valueOf(arr[i]),numbers);
            }
        }
        InputAndAnswer inputAndAnswer = new InputAndAnswer(input, Double.valueOf(numbers.pop().toString()));
        memoryRepository.save(inputAndAnswer);
        return Double.valueOf(numbers.pop().toString());
    }

    public String convPostfix(String input) {
        String c = String.valueOf(' ');
        Stack<Character> operationStack = new Stack<>(); //연산자 스택
        StringBuilder sb = new StringBuilder();
        char inputarr[] = input.toCharArray();
        for (int i = 0; i < inputarr.length; i++) {
            if(Character.isDigit(inputarr[i]) == true){//숫자면 표현
                sb.append(inputarr[i]);
            }else if(operationStack.isEmpty()){//연산자 스택이 비어있을 경우 값 push
                operationStack.push(inputarr[i]);
            }else{// 연산자가 스택에 있는 경우
                if (compareOperation(String.valueOf(operationStack.peek()), c) > 0) { //현재 연산자가 우선순위 더 높을 때
                    operationStack.push(inputarr[i]); // 연산자
                }
                while(!operationStack.isEmpty()) {
                    if (compareOperation(String.valueOf(operationStack.peek()), c) <= 0) {
                        sb.append(operationStack.pop());
                    } else {
                        break;
                    }
                }
                operationStack.push(inputarr[i]);
            }
        }
        return sb.toString();
    }

    public void calculateReal(Integer num1, Integer num2, String operation, Stack<Integer> stack){
        switch (operation) {
            case "+":
                 stack.push(num1 + num2);
            case "-":
                stack.push(num1 - num2);
            case "*":
                stack.push(num1 * num2);
            case "/":
                stack.push(num1 / num2);

        }
    }


    //연산자 우선순위 반환
    public static int getOperationPriority(String op) {
        switch (op) {
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 2;
            default:
                return -1;
        }
    }

    //연산자 우선순위 비교
    public static int compareOperation(String op, String opNow) {
        int operationPriority = getOperationPriority(op);
        int operationPriorityNow = getOperationPriority(opNow);

        if (operationPriorityNow > operationPriority) {
            return 1;
        } else if (operationPriorityNow == operationPriority) {
            return 0;
        } else{
            return -1;
        }

    }

}
