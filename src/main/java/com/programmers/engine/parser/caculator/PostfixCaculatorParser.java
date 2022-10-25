package com.programmers.engine.parser.caculator;

import com.programmers.engine.model.CaculatorParseData;
import com.programmers.engine.parser.caculator.CaculatorParser;
import com.programmers.util.Operator;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class PostfixCaculatorParser extends CaculatorParser {
    @Override
    protected CaculatorParseData parseToSometingfix(CaculatorParseData tokenizeData) {
        Stack<Character> operatorStack = new Stack<>();
        CaculatorParseData postfixExpression = new CaculatorParseData();
        Collection<?> tokenizedExpression = tokenizeData.getAllList();

        for (Object o : tokenizedExpression) {
            if(o instanceof Character){
                Character myOperator = (Character) o;
                try{
                    Character stackTop = operatorStack.peek();
                    int myPriority = Operator.getPriority(myOperator);
                    int stackTopPriority = Operator.getPriority(stackTop) ;
                    if(myPriority<stackTopPriority){
                        operatorStack.push(myOperator);
                    }else{
                        postfixExpression.add(operatorStack.pop());
                        operatorStack.push(myOperator);
                    }
                }catch (EmptyStackException e){
                    operatorStack.push(myOperator);
                }

            }else if(o instanceof Double){
                postfixExpression.add((Double) o);
            }
        }
        while(operatorStack.size()!=0){
            postfixExpression.add(operatorStack.pop());
        }
        return postfixExpression;
    }
}
