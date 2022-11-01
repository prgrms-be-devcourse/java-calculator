package com.programmers.caculation.model;

public class Expression {
    final String originExpression;
    final String result;
    String allExpression;


    public Expression(String expression, String result) {
        this.originExpression = expression;
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public String getAllExpression() {
        if (this.allExpression == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.originExpression);
            stringBuilder.append('=');
            stringBuilder.append(getResult());
            this.allExpression = stringBuilder.toString();
        }
        return this.allExpression;
    }
}
