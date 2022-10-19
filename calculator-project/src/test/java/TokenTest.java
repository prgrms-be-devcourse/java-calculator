import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class TokenTest {

    @Test
    void testMakeToken(){
        Token token = Token.makeToken("11.0");

        Assertions.assertEquals(token.getData(), "11.0");
        Assertions.assertEquals(token.getType(), Token.NUMBER);
        Assertions.assertEquals(token.getSize(), 4);

        System.out.println(token.convertData2Number()+2);
    }

    @Test
    void testMakeTokenList(){
        String operation = "2.3+3.3";
        List<Token> tokenList = Token.makeTokenList(operation);

        for(var token : tokenList){
            System.out.println(token.getData());
        }
        List<Token> expect = new ArrayList<>();
        expect.add(Token.makeToken("2.3"));
        expect.add(Token.makeToken("+"));
        expect.add(Token.makeToken("3.3"));
        for(var token : expect){
            System.out.println(token.getData());
        }
    }

    @Test
    void testPostfixTokenList(){
        String operation = "2.3+3.3";
        List<Token> tokenList = Token.makeTokenList(operation);
        List<Token> postfixTokenList = Token.postfixConverter(tokenList);
        for(var token : postfixTokenList){
            System.out.println(token.getData());
        }
    }



}
