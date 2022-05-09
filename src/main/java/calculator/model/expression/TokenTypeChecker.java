package calculator.model.expression;

import calculator.model.operand.Operand;
import calculator.model.operator.OperatorFactory;
import calculator.model.operator.OperatorType;
import calculator.model.operator.bracket.CloseBracketOperator;
import calculator.model.operator.bracket.OpenBracketOperator;
import calculator.module.validator.exception.InvalidTokenException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TokenTypeChecker 설명
 * 입력 받은 원시 문자열이 수식을 구성할수있는 타입의 토큰인지 확인하고 타입에 맞는 객체를 생성하여 반환
 * ex) 22 + 33 수식에서 수식을 구성할 수 있는 토큰은 연산자와 피연산자
 * 원시 토큰이 22 혹은 33이라면 Operand 객체를 생성하여 반환, +라면 Operator 객체를 생성하여 반환
 **/

public class TokenTypeChecker {
    private static final String INVALID_TOKEN_EXIST_MESSAGE = "수식에 유효하지 않은 구문이 들어있습니다.";
    private List<String> operatorList;
    private final OperatorFactory operatorFactory;

    public TokenTypeChecker(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
        initOperatorList();
    }

    public ExpressionableToken[] createTypeCheckedToken(String[] tokenArray) throws InvalidTokenException {
        List<ExpressionableToken> classifiedTokens = new ArrayList<>();
        for (String token : tokenArray) {
            classifiedTokens.add(classifyToken(token));
        }
        return classifiedTokens.toArray(new ExpressionableToken[0]);
    }

    private ExpressionableToken classifyToken(String token) throws InvalidTokenException {
        if (isOperator(token))
            return operatorFactory.makeOperator(token); // 연산자의 경우 추가될 가능성이 높기 때문에 별도의 팩토리 클래스로 생성
        else if (Operand.isOperand(token))
            return new Operand(token);
        else if ("(".equals(token)) {
            return new OpenBracketOperator();
        } else if (")".equals(token)) {
            return new CloseBracketOperator();
        } else
            throw new InvalidTokenException(INVALID_TOKEN_EXIST_MESSAGE + token);
    }

    private void initOperatorList() {
        this.operatorList = Arrays.stream(OperatorType.values())
                .map(OperatorType::getSymbol).
                collect(Collectors.toList());
    }

    private boolean isOperator(String target) {
        return operatorList.contains(target);
    }

}
