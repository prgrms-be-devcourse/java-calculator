package model;

import java.util.Stack;
import java.util.StringTokenizer;
public class Operation {
    private Stack<Integer> numberStack = new Stack<>();
    private Stack<String> operStack = new Stack<>();

    public Integer operate(String inputString) {

        StringTokenizer st = new StringTokenizer(inputString);

        classifyOperatorAndNumber(st);

        return calculate();
    }
    private void classifyOperatorAndNumber(StringTokenizer st){

        while(st.hasMoreTokens()){
            String word = st.nextToken();
            Operator operator = null;
            if(!(Operator.getOperator(word).isEmpty())){
                operator = Operator.getOperator(word).get();
            }

            switch (operator != null ? operator : operator.NULL){
                case MULTIPLY : case DIVIDE:
                    numberStack.push(Integer.parseInt(st.nextToken()));
                    calculateMultiplyOrDivide(operator.toString());
                    break;
                case PLUS : case MINUS:
                    operStack.add(operator.toString());
                    break;
                case NULL:

                    if(operStack.isEmpty() || operStack.pop().equals("PLUS")){
                        numberStack.push(Integer.parseInt(word));
                        break;
                    }

                    numberStack.push(-1*Integer.parseInt(word));
                    break;
            }
        }


    }

    private Integer calculate(){
        while(true){
            if(numberStack.size() == 1) break;

            int num2 = numberStack.pop();
            int num1 = numberStack.pop();

            numberStack.push(num1 + num2);
        }

        return numberStack.pop();
    }

    private void calculateMultiplyOrDivide(String word) {
        int num2 = numberStack.pop();
        int num1 = numberStack.pop();

        if(word.equals("MULTIPLY")) numberStack.push(num1*num2);

        else numberStack.push(num1/num2);
    }
}
