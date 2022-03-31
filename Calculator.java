import java.util.Stack;

public class Calculator {

    public enum Operator{ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK}

//    public static void main(String[] args){
//        String expression = "2+2*8";
//        Calculator calc = new Calculator();
//        System.out.println(calc.compute(expression));
//    }

    public double compute(String sequence){
        Stack<Double> numberStack = new Stack<Double>();
        Stack<Operator> operatorStack = new Stack<Operator>();
        for(int i = 0; i < sequence.length(); i++){
//            System.out.println("---------------------------------------------");
            try{
                // number: operation 사이의 넘버
                int number = parseNumber(sequence, i);
//                System.out.printf("number: %d, i: %d\n", number, i);
                numberStack.push((double)number);

                // i에 number의 자리수 만큼 더함. 23 이면 2개 더함.
                i += Integer.toString(number).length();
                if(i >= sequence.length()){
                    break;
                }

//                System.out.printf("parse operator parameter: %s, %d\n", sequence, i);
                Operator op = parseOperator(sequence, i);

//                System.out.println("Call Collaps TOP 1");
                collapseTop(numberStack, operatorStack, op);
                operatorStack.push(op);
            } catch(NumberFormatException ex){
                return Integer.MIN_VALUE;
            }
//            System.out.println("---------------------------------------------");

        }
//        System.out.println("Call Collaps TOP 2");
        collapseTop(numberStack, operatorStack, Operator.BLANK);
        if(numberStack.size() == 1 && operatorStack.size() == 0){
            return numberStack.pop();
        }
        return 0;
    }


    private void collapseTop(Stack<Double> numberStack, Stack<Operator> operatorStack, Operator futureTop){
        while(numberStack.size() >= 2 && operatorStack.size() >= 1){
//            System.out.println("NumberStack: "  + numberStack);
//            System.out.println("OperatorStack: "  + operatorStack);
//            System.out.println("FutureTop:" + futureTop);
//            System.out.println("operatorStack.peek():" + operatorStack.peek());
            if(priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())){
                double second = numberStack.pop();
                double first = numberStack.pop();
                Operator op = operatorStack.pop();
//                System.out.println("op = " + op);
                double result = applyOp(first, op, second);
                numberStack.push(result);
            } else{
                break;
            }
        }
    }

    private double applyOp(double left, Operator op, double right){
        switch (op){
            case ADD: return left + right;
            case SUBTRACT: return left - right;
            case MULTIPLY: return left * right;
            case DIVIDE: return left / right;
            default: return right;
        }

    }

    private int priorityOfOperator(Operator op){
        switch (op){
            case ADD: return 1;
            case SUBTRACT: return 1;
            case MULTIPLY: return 2;
            case DIVIDE: return 2;
            case BLANK: return 0;
        }
        return 0;
    }

    private int parseNumber(String sequence, int offset){
        StringBuilder sb = new StringBuilder();
        while(offset < sequence.length() && Character.isDigit(sequence.charAt(offset))){
            sb.append(sequence.charAt(offset));
            offset++;
        }
        return Integer.parseInt(sb.toString());
    }

    private Operator parseOperator(String sequence, int offset){
//        System.out.println("--------------start parseOperator------------------");
        if(offset < sequence.length()){
//            System.out.println("offset: " + offset);
//            System.out.println("sequence.length(): "+ sequence.length());
            char op = sequence.charAt(offset);
            switch (op){
                case '+': return Operator.ADD;
                case '-': return Operator.SUBTRACT;
                case '*': return Operator.MULTIPLY;
                case '/': return Operator.DIVIDE;
            }
        }
        return Operator.BLANK;
    }
}