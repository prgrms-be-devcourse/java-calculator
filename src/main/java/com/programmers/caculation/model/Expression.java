package com.programmers.caculation.model;

public class Expression {
    final String originExpression;
    String result;
    String allExpression;


    public Expression(String expression, String result) {
        this.originExpression = expression;
        this.result = result;
    }

    public String getExpression() {
        return this.originExpression;
    }

    public String getResult() throws Exception {
        return this.result;
    }

    public String getAllExpression() throws Exception {
        if (this.allExpression == null) {
            StringBuffer sb = new StringBuffer();
            sb.append(this.originExpression);
            sb.append('=');
            sb.append(getResult());
            this.allExpression = sb.toString();
        }
        return this.allExpression;
    }
}
