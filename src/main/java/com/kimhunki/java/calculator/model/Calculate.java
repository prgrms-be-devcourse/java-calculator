package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.strategy.CalculateStrategy;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class Calculate implements CalculateStrategy
{
    Console console;

    @Override
    public void calculate(ResultRepository resultRepository)
    {
        int result = 0;
        String expression =  console.input("");
        if(expression.isBlank() || !Character.isDigit(expression.charAt(expression.length()-1)))
        { // 그냥 엔터를 눌렀을 경우 or 마지막이 숫자가 아닌경우
            console.inputError();
            return;
        }

        
        List<String> expressionList = splitString(expression);
        
        if(!isExpression(expressionList)) // 올바른 수식으로 되어있는지 확인
        {
            console.inputError();
            return;
        }
        Stack<String> expressStack = new Stack<>();
        String symbol = ""; // *나 /가 나오면 부호 저장
        for(String element : expressionList) // * , / 먼저 계산
        {
            if(symbol.equals("*") || symbol.equals("/"))
            {
                Integer num1 = Integer.parseInt(expressStack.pop()); // 팝
                Integer num2 = Integer.parseInt(element);
                if(symbol.equals("*"))
                    expressStack.add(Integer.toString(num1*num2));
                else expressStack.add(Integer.toString(num1/num2));
                symbol = "";
            }
            else if(element.equals("*") || element.equals("/"))
            {
                symbol = element;
            }
            else
                expressStack.add(element);
        }
        result = Integer.parseInt(expressStack.get(0)); // 초기값 결과에 넣어둠
        for(int i=1; i<expressStack.size(); i+=2)
        {
            if(expressStack.get(i).equals("+")) // +,-만 있으므로 뒤에 결과만 result에 더해줌
                result += Integer.parseInt(expressStack.get(i+1));
            else
                result -= Integer.parseInt(expressStack.get(i+1));
        }
        console.output(Integer.toString(result));
        resultRepository.getResultList().add(expression + " = " + result);

    }
    private List<String> splitString(String expression)
    {
        String[] splitString = expression.split(" ");
        List<String> arrayString = new ArrayList<>();
        Collections.addAll(arrayString, splitString);

        return arrayString;
    }

    private boolean isNumber(String num) // 숫자인지
    {
        for(int i=0; i<num.length(); i++)
        {
            if(!Character.isDigit(num.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    private boolean isSymbol(String symbol) // 부호인지
    {
        if (symbol.equals("+") ||symbol.equals("-") || symbol.equals("*") ||symbol.equals("/") )
            return true;
        return false;
    }

    private boolean isExpression(List<String> expressionList) // 올바른 식으로 구성되어 있는지 확인
    {
        int state = 0; // 숫자인지 부호인지 상태 확인하는 코드
        int divideFlag = 0;  // 이전 부호가 나누기인지 아닌지 확인하는 코드
        for (String s : expressionList) // s가 스택에 쌓인 스트링(부호 혹은 숫자)
        {
            if (state == 0 && isNumber(s)) // 숫자라면
            {
                if (divideFlag != 0 && s.equals("0")) return false;
                state = 1;
            } else if (state == 1 && isSymbol(s)) // 숫자가 아니라면
            {
                if (s.equals("/")) divideFlag = 1;
                else divideFlag = 0;
                state = 0;
            }
            else{ // 만약 올바르지 않다면
                return false;
            }
        }
        if(state == 0) // 마지막이 부호로 끝난다면 잘못된 수식.
            return false;
        return true;
    }


}
