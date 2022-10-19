package utility;

public class Utility {

    public static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    public static int bufferStringToInt(StringBuffer br) {
        return Integer.parseInt(br.toString());
    }
}
