package entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;


class ExpressionTest {

    AtomicLong id;

    @BeforeEach
    void clearId(){
        id = new AtomicLong(1L);
    }

    @Test
    void toStringTest(){

        String input = "1 + 2";
        double result = 3;
        String toStringValue = input + " = " + result;

        Expression expression = new Expression(id.getAndIncrement(),input, result);

        Assertions.assertThat(toStringValue).isEqualTo(expression.toString());
    }

    @Test
    void idIncrementTest(){

        for (long i = 0; i < 10; i++) {
            Assertions.assertThat(id.getAndIncrement()).isEqualTo(1+i);
        }
    }


}