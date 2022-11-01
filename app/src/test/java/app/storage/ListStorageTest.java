package app.storage;

import app.calculator.Answer;
import app.calculator.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListStorageTest {

    private final ListStorage listStorage = new ListStorage();

    @BeforeEach
    void init() {
        listStorage.removeAll();
    }

    @DisplayName("save 확인")
    @Test
    void saveTest() {
        // given
        Expression expression = new Expression("1 + 2 + 3");
        Integer expressionAnswer = 6;
        String testAnswer = "1 + 2 + 3 = 6";

        // when
        String result = listStorage.save(expression, Answer.createCorrectAnswer(expressionAnswer));

        // then
        Assertions.assertThat(result).isEqualTo(testAnswer);
    }

    @DisplayName("findAll 확인")
    @Test
    void findAllTest() {
        // given
        listStorage.save(new Expression("1 + 2 + 3"), Answer.createCorrectAnswer(6));
        listStorage.save(new Expression("10 - 5"), Answer.createCorrectAnswer(5));
        String answer = "1 + 2 + 3 = 6\n10 - 5 = 5\n";

        // when
        String result = listStorage.findAll();

        // then
        Assertions.assertThat(result).isEqualTo(answer);
    }
}