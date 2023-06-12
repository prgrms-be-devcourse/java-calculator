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
    // 숫자와 연산자를 구분하고 각자 스택에 넣어줍니다
    private void classify(StringTokenizer st){

        while(st.hasMoreTokens()){
            String word = st.nextToken();

            if (word.equals("+") || word.equals("-")) operStack.add(word);
                // 곱하기나 나누기 연산자가 나오면 먼저 계산합니다
            else if(word.equals("*") || word.equals("/")) calPriority(word,Integer.parseInt(st.nextToken()));

            else {
                if(operStack.isEmpty() || operStack.pop().equals("+")){
                    numberStack.push(Integer.parseInt(word));

                }
                else{
                    numberStack.push(-1*Integer.parseInt(word));
                }

            }
        }


    }

    private void cal(){
        while(true){
            if(numberStack.size() == 1) break;

            int num2 = numberStack.pop();
            int num1 = numberStack.pop();

            numberStack.push(num1 + num2);

//            if(operStack.pop().equals("+")) numberStack.push(num1 + num2);
//            else numberStack.push(num1 - num2);


        }
    }

    private void calPriority(String word,int num2) {
        int num1 = numberStack.pop();

        if(word.equals("*")) numberStack.push(num1*num2);

        else numberStack.push(num1/num2);


    }
}
