package entity;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Expression {

    private Long id;
    private String input;
    private double result;

    public Expression(Long id, String input, double result) {
        this.id = id;
        this.input = input;
        this.result = result;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(this.input).append(" = ").append(this.result);

        return sb.toString();
    }
}
