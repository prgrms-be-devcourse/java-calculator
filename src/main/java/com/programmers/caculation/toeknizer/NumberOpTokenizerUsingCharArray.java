package com.programmers.caculation.toeknizer;

import com.programmers.caculation.model.NumberAndOperator;

import java.util.ArrayList;
import java.util.List;

public class NumberOpTokenizerUsingCharArray implements Tokenizer {
    private final StringBuffer sb = new StringBuffer();
    private char[] expressionCharArray;

    @Override
    public List<NumberAndOperator> tokenize(String expression) throws Exception {
        List<NumberAndOperator> tokenizedInput = new ArrayList<>();
        expressionCharArray = expression.replace(" ", "").toCharArray();
        checkValidatinoAndAddToResultList(tokenizedInput);
        addNumberToResultThatRemainInStringBuffer(tokenizedInput);
        return tokenizedInput;
    }

    private void addNumberToResultThatRemainInStringBuffer(List<NumberAndOperator> tokenizedInput) {
        if (sb.length() != 0) {
            NumberAndOperator number = new NumberAndOperator(Double.parseDouble(sb.toString()));
            tokenizedInput.add(number);
            sb.delete(0, sb.length());
        }
    }

    private void checkValidatinoAndAddToResultList(List<NumberAndOperator> tokenizedList) throws Exception {
        for (int currIndex = 0; currIndex < expressionCharArray.length; currIndex++) {
            checkCurrCharCanAddToResultAndIfCanAddToResult(tokenizedList, currIndex);
        }
    }

    private void checkCurrCharCanAddToResultAndIfCanAddToResult(List<NumberAndOperator> tokenizedList, int currIndex) throws Exception {
        char currChar = expressionCharArray[currIndex];
        switch (currChar) {
            case '*', '/', '+', '-' -> addStringBufferToResultIfCan(tokenizedList, currIndex, currChar);
            case '=' -> checkEqualLocationAndAddToResult(tokenizedList, currIndex);
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> addcurrCharToStringBuffer(currChar);
            default -> makeEceptionAboutWrongCharacter();
        }
    }
    private void addStringBufferToResultIfCan(List<NumberAndOperator> tokenizedList, int currIndex, char currChar) throws Exception {
        makeEceptionOperatorInLast(currIndex);//가장 마지막이 연산자로 띁나면 실패하게
        addStringBufferToResultIfFailMakeExceptionContinuousOperator(tokenizedList, currIndex, currChar);//연산자가 2개 연달아 오는 것을 체크,가장 앞에 오는 +, -는 통과하게함
    }
    private void addcurrCharToStringBuffer(char currChar) {
        sb.append(currChar);
    }
    private void checkEqualLocationAndAddToResult(List<NumberAndOperator> tokenizedList, int currIndex) throws Exception {
        if (currIndex == (expressionCharArray.length - 1)) {
            NumberAndOperator number = new NumberAndOperator(Double.parseDouble(sb.toString()));
            tokenizedList.add(number);
            sb.delete(0, sb.length());
        } else {
            sb.delete(0, sb.length());
            throw new Exception("=의 뒤에는 숫자를 넣을 수 없습니다.");
        }
    }
    private void makeEceptionAboutWrongCharacter() throws Exception {
        sb.delete(0, sb.length());
        throw new Exception("잘못된 식입니다.");
    }
    
    private void makeEceptionOperatorInLast(int currIndex) throws Exception {
        if (currIndex == (expressionCharArray.length - 1)) {
            sb.delete(0, sb.length());
            throw new Exception("연산자는 가장 마지막에 올 수 없습니다.");
        }
    }

    private void addStringBufferToResultIfFailMakeExceptionContinuousOperator(List<NumberAndOperator> tokenizedList, int currIndex, char currChar) throws Exception {
        try {
            NumberAndOperator number = new NumberAndOperator(Double.parseDouble(sb.toString()));
            tokenizedList.add(number);
            NumberAndOperator op = new NumberAndOperator(currChar);
            tokenizedList.add(op);
            sb.delete(0, sb.length());
        } catch (NumberFormatException e) {
            if ((currIndex == 0 && currChar == '+') || (currIndex == 0 && currChar == '-')) {
                addcurrCharToStringBuffer(currChar);
            } else {
                sb.delete(0, sb.length());
                throw new Exception("연산자는 연달아 두번 이상 올 수 없습니다.");
            }
        }
    }





}
