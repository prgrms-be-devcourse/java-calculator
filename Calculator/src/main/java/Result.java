public class Result {

    private String expression;
    private String answer;

    public Result(String expression, String answer) {
        this.expression = formalize(expression);
        this.answer = answer;
    }

    private String formalize(String expression) {
        StringBuilder sb = new StringBuilder();
        char c;

        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);

            if (!Character.isDigit(c)) sb.append(' ').append(c).append(' ');
            else sb.append(c);
        }

        if (sb.length() > 1 && sb.charAt(1) == '-') {
            sb.deleteCharAt(2);
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public String fullEquation() {
        return expression + " = " + answer + "\n";
    }

}
