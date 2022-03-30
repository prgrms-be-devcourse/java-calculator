package caculator.engine;

import caculator.engine.module.*;
import caculator.exception.WrongFormulaException;
import caculator.io.IO;
import caculator.io.CalculatorIO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private ArrayList<StringBuilder> history;
    private ArrayList<String> tokens;
    private int tokensIdx;
    private IO calculatorIO;
    private CalculatorModule plusModule;
    private CalculatorModule minusModule;
    private CalculatorModule multiplyModule;
    private CalculatorModule divideModule;

    public Calculator() {
        this.history = new ArrayList<>();
        this.calculatorIO = new CalculatorIO();
        this.plusModule = new PlusModule();
        this.minusModule = new MinusModule();
        this.multiplyModule = new MultiplyModule();
        this.divideModule = new DivideModule();
    }

    public void tokensInitialze() {
        tokens = new ArrayList<>();
        tokensIdx = 0;
    }

    public boolean isFormula(StringBuilder formula) throws WrongFormulaException {
        String formulaPattern = "^-?\\d+([\\+\\-\\*\\/]\\d+)*$";

        if (!Pattern.matches(formulaPattern, formula.toString())) {
            throw new WrongFormulaException("올바른 사칙연산을 입력하세요.");
        }
        return true;
    }

    //calculate sum of terms in formula
    //if next operator is + or - , prev operand is add into answer
    //if next operator is * or / , the operation is performed until only one operand remains
    public float calculate(StringBuilder formula) throws Exception {
        float currentTerm;
        float answer = 0;
        String operator;

        tokensInitialze();
        tokens = parseTokensWithString(formula.toString());
        tokensIdx = 0;
        currentTerm = getNextOperand();
        try{
            while(tokensIdx < tokens.size()) {
                operator = getNextOperator();
                switch (operator) {
                    case "+" -> {
                        answer = plusModule.execute(answer, currentTerm);
                        currentTerm = getNextOperand();
                    }
                    case "-" -> {
                        answer = plusModule.execute(answer, currentTerm);
                        currentTerm = - getNextOperand();
                    }
                    case "*" -> {
                        currentTerm = multiplyModule.execute(currentTerm, getNextOperand());
                    }
                    case "/" -> {
                        currentTerm = divideModule.execute(currentTerm, getNextOperand());
                    }
                }
            }
        }
        catch (Exception e) {
            throw e;
        }
        //add last term
        answer += currentTerm;
        return answer;
    }

    //make formula into tokens list
    //tokens are either operand or operator
    private ArrayList<String> parseTokensWithString(String formula) {
        Pattern pattern = Pattern.compile("^-?\\d+");
        Matcher matcher = pattern.matcher(formula);
        int idx = 0;

        //first element is always operand token(ex: -23,312)
        while (matcher.find()) {
            tokens.add(matcher.group());
            idx = matcher.end();
        }
        //second element is operator token + operand token (ex: +23,-123,*6,/3)
        pattern = Pattern.compile("[\\+\\-\\*\\/]\\d+");
        matcher = pattern.matcher(formula.toString().substring(idx));
        while (matcher.find()) {
            String tk = matcher.group();
            //seperate operator with operand
            tokens.add(tk.substring(0, 1));
            tokens.add(tk.substring(1));
        }
        return tokens;
    }

    public float getNextOperand() {
        return Float.parseFloat(tokens.get(tokensIdx++));
    }

    public String getNextOperator() {
        return tokens.get(tokensIdx++);
    }

    public void saveEquation(StringBuilder formula, Float result) {
        StringBuilder equation = new StringBuilder("");
        equation.append(formula);
        equation.append(" = ");
        equation.append(new DecimalFormat("#.##").format(result));
        history.add(equation);
    }

    public void showHistory() {
        calculatorIO.print(history);
    }
}
