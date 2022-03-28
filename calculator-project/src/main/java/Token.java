import lombok.EqualsAndHashCode;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@EqualsAndHashCode
public class Token {
    public static int OPERATOR = 1, NUMBER = 2;

    private String data;
    private int type;
    int size = 0;
    private StringBuffer stringBuffer = new StringBuffer();

    public void append(char a){
        size++;
        stringBuffer.append(a);
    }
    public void build(){
        data = stringBuffer.toString();
    }

    public void setType(int type){
        this.type = type;
    }
    public String getData(){
        return data;
    }
    public Double convertData2Number(){
        return Double.parseDouble(data);
    }

    public char getOperator(){
        return data.charAt(0);
    }
    public int getType(){
        return type;
    }
    public int getSize(){
        return size;
    }

    public static Token makeToken(String str){
        Token token = new Token();
        if(ICalculator.isOperator(str.charAt(0))) {
            token.setType(Token.OPERATOR);
        }
        else {
            token.setType(Token.NUMBER);
        }

        for(int i=0;i<str.length();i++){
            token.append(str.charAt(i));
        }
        token.build();
        return token;
    }
    public static List<Token> makeTokenList(String operation){
        List<Token> tokenList = new ArrayList<>();

        Token token = new Token();

        for (int i = 0; i < operation.length(); i++) {
            char op = operation.charAt(i);

            if(ICalculator.isOperator(op)){
                token.setType(Token.NUMBER);
                token.build();
                tokenList.add(token);

                token = new Token();
                token.append(op);
                token.setType(Token.OPERATOR);
                token.build();
                tokenList.add(token);

                token = new Token();
                continue;
            }
            token.append(op);
        }
        if(token.getSize() > 0){
            token.setType(Token.NUMBER);
            token.build();
            tokenList.add(token);
        }
        return tokenList;
    }
    public static List<Token> postfixConverter(List<Token> tokenList){
        Stack<Token> stack = new Stack<>();
        List<Token> postfix = new ArrayList<>();

        for(var token : tokenList){
            if(token.getType() == Token.OPERATOR){
                char ch = token.getData().charAt(0);
                while (!stack.empty() && ICalculator.priority(ch) <= ICalculator.priority(stack.peek().getOperator())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
            else{
                postfix.add(token);
            }
        }

        while (!stack.empty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

}
