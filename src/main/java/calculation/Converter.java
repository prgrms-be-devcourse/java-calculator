package calculation;

public interface Converter {
    String convert();

    static String removeWhiteSpace(String targetExpr) {
        return targetExpr.replace(" ", "");
    }
}
