package calcproject.util;

public class CalcExpressionTokenizer {

    private static boolean isDigit(char ch){
        if(ch >= '0' && ch <= '9') {
            return true;
        }else{
            return false;
        }
    }


}
