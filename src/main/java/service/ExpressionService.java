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

    /**
     * 콘솔로 입력받은 수식을 통해 Expression 객체를 생성하고 검증 후,
     * 곱셈, 나눗셈 연산을 수행한 뒤 덧셈, 뺄셈 연산을 수행합니다.
     * 계산이 완료되면 메모리에 해당 Expression 객체를 저장 후 계산 결과값을 반환합니다.
     */
    public double calculateExpression(String exprInput) {
        Expression expression = new Expression(exprInput);
        List<String> exprResults = new ArrayList<>();
        multiplyAndDivide(expression, exprResults);
        plusAndMinus(expression, exprResults);
        expRepository.save(expression);
        return expression.getCalcResult();
    }

    /**
     * exprResults 리스트에 곱셈, 나눗셈이 수행된 연산자, 피연산자를 저장합니다.
     * 예를 들어, 10 + 1 * 9 - 10 / 2 가 입력되었다면
     * 리스트에는 ["10", "+", "9", "-", "5"]가 저장됩니다.
     */
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

    /**
     * 연산자를 기준으로 덧셈, 뺄셈 계산을 수행합니다.
     * 수행된 결과는 Expression 객체에 결과값 필드인 calcResult를 set해 넣어줍니다.
     */
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
