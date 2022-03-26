package service;

import model.Calculator;
import model.Expression;
import repository.ExpressionRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class ExpressionService {
    private final ExpressionRepository expRepository;

    public ExpressionService(ExpressionRepository expRepository) {
        this.expRepository = expRepository;
    }

    public List<Expression> findAllExpression() {
        return expRepository.findAll();
    }

    public double calculateExpression(String exprInput) {
        Expression expression = new Expression(exprInput);
        List<String> exprResults = new ArrayList<>();
        multiplyAndDivide(expression, exprResults);
        plusAndMinus(expression, exprResults);
        expRepository.save(expression);
        return expression.getCalcResult();
    }

    private void multiplyAndDivide(Expression expression, List<String> exprResults) {
        Calculator calculator = new Calculator();
        String[] splitExpr = expression.getExpression().split(" ");
        for(int i = 0; i< splitExpr.length; i++){
            if(splitExpr[i].equals("*") || splitExpr[i].equals("/")){
                String operator = splitExpr[i];
                int lastIndex = exprResults.size()-1;
                double firstNum = parseDouble(exprResults.get(lastIndex));
                double secondNum = parseDouble(splitExpr[i + 1]);
                double resultNum = calculator.calculate(firstNum, secondNum, operator);
                exprResults.remove(lastIndex);
                exprResults.add(String.valueOf(resultNum));
                i++;
            } else {
                exprResults.add(splitExpr[i]);
            }
        }
    }

    private void plusAndMinus(Expression expression, List<String> exprResults) {
        Calculator calculator = new Calculator();
        double resultNum = parseDouble(exprResults.get(0));
        for(int i = 1; i< exprResults.size(); i+=2){
            String operator = exprResults.get(i);
            double secondNum = parseDouble(exprResults.get(i+1));
            resultNum = calculator.calculate(resultNum, secondNum, operator);
        }
        expression.setCalcResult(resultNum);
    }
}
