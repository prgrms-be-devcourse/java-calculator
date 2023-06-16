package model;

import java.util.Stack;
import java.util.StringTokenizer;
public class Operator {
    private Stack<Integer> numberStack = new Stack<>();
    private Stack<String> operStack = new Stack<>();

    public Integer operate(String inputString) {

        StringTokenizer st = new StringTokenizer(inputString);

        classify(st);

        cal();

        return numberStack.pop();
    }
    private void classify(StringTokenizer st){

        while(st.hasMoreTokens()){
            String word = st.nextToken();

            if(!(OperatorList.getOperator(word).isEmpty())){
                word = OperatorList.getOperator(word).get().name();
            }

            switch (word){
                case "MULTIPLY" : case "DIVIDE":
                    calPriority(word,Integer.parseInt(st.nextToken()));
                    break;
                case "PLUS" : case "MINUS":
                    operStack.add(word);
                    break;
                default:
                    if(operStack.isEmpty() || operStack.pop().equals("PLUS")){
                        numberStack.push(Integer.parseInt(word));
                        break;
                    }

                    numberStack.push(-1*Integer.parseInt(word));
                    break;
            }
        }


    }

    private void cal(){
        while(true){
            if(numberStack.size() == 1) break;

            int num2 = numberStack.pop();
            int num1 = numberStack.pop();

            numberStack.push(num1 + num2);


        }
    }

    private void calPriority(String word,int num2) {
        int num1 = numberStack.pop();

        if(word.equals("MULTIPLY")) numberStack.push(num1*num2);

        else numberStack.push(num1/num2);


    }
}
