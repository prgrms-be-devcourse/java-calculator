package model;

import java.util.Stack;
import java.util.StringTokenizer;

public class Operator {
    static Stack<Integer> numberStack = new Stack<>();
    static Stack<String> operStack = new Stack<>();
    public Integer operate(String inputString) {

        StringTokenizer st = new StringTokenizer(inputString);

        classify(st);

        cal();

        return numberStack.pop();
    }

    private static void classify(StringTokenizer st){

        while(st.hasMoreTokens()){
            String word = st.nextToken();

            if (word.equals("+") || word.equals("-")) operStack.add(word);

            else if(word.equals("*") || word.equals("/")) calPriority(word,Integer.parseInt(st.nextToken()));

            else {
                numberStack.push(Integer.parseInt(word));
            }
        }


    }

    private static void cal(){
        while(!operStack.isEmpty()){
            int num2 = numberStack.pop();
            int num1 = numberStack.pop();

            if(operStack.pop().equals("+")) numberStack.push(num1 + num2);
            else numberStack.push(num1 - num2);


        }
    }

    private static void calPriority(String word,int num2) {
        int num1 = numberStack.pop();

        if(word.equals("*")) numberStack.push(num1*num2);

        else numberStack.push(num1/num2);
    }
}
