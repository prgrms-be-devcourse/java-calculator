package javacalculator.calculator;

public enum Operator {
    PLUS("+", 0) {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-", 0) {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*", 1) {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 * operand2;
        }
    },
    DIVIED("/", 1) {
        @Override
        public double apply(double operand1, double operand2) {
            if (operand2 == 0.0) {
                throw new IllegalArgumentException();
            }
            return operand1 / operand2;
        }
    };

    private final String textOperator;
    private final int priority;

    Operator(String textOperator, int priority) {
        this.textOperator = textOperator;
        this.priority = priority;
    }


    public static int getPriority(String textOperator) {
        Operator operator = getOperator(textOperator);
        return operator.priority;
    }

    public static boolean isTextOperator(String inputTextOperator) {
        try {
            getOperator(inputTextOperator);
            return true;
        } catch(IllegalArgumentException e) {
            return false;
        }
    }

    public static Operator getOperator(String textOperator) {
        Operator operator = null;
        for (Operator op : Operator.values()) {
            if (op.getTextOperator().equals(textOperator)) {
                operator = op;
                break;
            }
        }
        if (operator == null) throw new IllegalArgumentException("올 바르지 않은 연산자입니다.");
        
        return operator;
    }

    public abstract double apply(double operand1, double operand2);
    
    public String getTextOperator() {
        return this.textOperator;
    }
}
