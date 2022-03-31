package fakeModel;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

public class FakeCalculator {
    private ArrayList<String> posixList=new ArrayList<String>();

    public String getPosixList(){
        String str="";
        for(int i=0; i<posixList.size(); i++){
            str+=posixList.get(i);
        }
        return str;
    }

    public String calculate(String[] userStr){
        changeToPosix(userStr);
        //posixList 계산
        Stack<Double> stack=new Stack<Double>();
        double ans=0;
        for(String str : posixList){
            Optional<FakeOperator> operator= FakeOperator.getOperator(str);
            if(operator.isEmpty()) {
                //피연산자
                stack.push(Double.parseDouble(str));
                continue;
            }
            //연산자
            if(stack.size()>=2){
                double num1=stack.pop();
                double num2=stack.pop();
                ans= FakeOperator.calculate(str, num2, num1);
            }
            stack.push(ans);
        }

        if(ans==(int)ans) return Integer.toString((int)ans);
        return String.format("%.2f", stack.pop());
    }

    public void changeToPosix(String[] userStr) throws NumberFormatException{
        Stack<FakeOperator> stack=new Stack<FakeOperator>();
        for(String str : userStr){
            // null이면 A, 아니면 B 로직 함수화 가능할듯.
            Optional<FakeOperator> operator=FakeOperator.getOperator(str);
            if(operator.isPresent()) {
                //연산자
                if (stack.isEmpty()) stack.push(operator.get());
                else {
                    int diff=stack.peek().getPriority()-operator.get().getPriority();
                    if(diff>=0) posixList.add(stack.pop().toString());
                    stack.push(operator.get());
                }
                continue;
            }
            posixList.add(str);
        }
        while(!stack.isEmpty()){
            posixList.add(stack.pop().toString());
        }
    }
}
