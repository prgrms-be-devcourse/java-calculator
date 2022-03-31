package calculator.model.token;

import calculator.model.operand.Operand;
import calculator.model.operator.OperatorFactory;
import calculator.model.operator.OperatorType;
import calculator.module.validator.exception.InvalidTokenException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TokenClassifier {
    private final static String INVALID_TOKEN_EXIST_MESSAGE = "수식에 유효하지 않은 구문이 들어있습니다.";
    private List<String> operatorList;
    private final OperatorFactory operatorFactory;

    public TokenClassifier(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
        initOperatorList();
    }

    public Tokenizationable classifyToken(String token) throws InvalidTokenException {
        if (isOperator(token))
            return operatorFactory.makeOperator(token); // 연산자의 경우 추가될 가능성이 높기 때문에 별도의 팩토리 클래스로 생성
        else if (Operand.isOperand(token))
            return new Operand(token);
        else
            throw new InvalidTokenException(INVALID_TOKEN_EXIST_MESSAGE + token);
    }

    private void initOperatorList(){
        this.operatorList= Arrays.stream(OperatorType.values())
                .map(OperatorType::getSymbol).
                collect(Collectors.toList());
    }

    private boolean isOperator(String target){
        return operatorList.contains(target);
    }
}
