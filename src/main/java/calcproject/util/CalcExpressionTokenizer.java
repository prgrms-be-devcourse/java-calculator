package calcproject.util;

public class CalcExpressionTokenizer {

    private static final boolean isDigit(char ch){
        if(ch >= '0' && ch <= '9') {
            return true;
        }else{
            return false;
        }
    }


}
