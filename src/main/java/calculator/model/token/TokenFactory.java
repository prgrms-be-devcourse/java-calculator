package calculator.model.token;

import calculator.module.validator.exception.InvalidTokenException;

import java.util.ArrayList;
import java.util.List;

public class TokenFactory {
    TokenClassifier tokenClassifier;

    public TokenFactory(TokenClassifier tokenClassifier){
        this.tokenClassifier = tokenClassifier;
    }

    public Tokenizationable[] makeToken(String [] tokenArray) throws InvalidTokenException {
        List<Tokenizationable> classifiedTokens = new ArrayList<>();
        String invalidDelimiter = " ";
        for (String token : tokenArray) {
            if(token.equals(invalidDelimiter))
                continue;
            classifiedTokens.add(tokenClassifier.classifyToken(token));
        }
        return classifiedTokens.toArray(new Tokenizationable[0]);
    }
}


