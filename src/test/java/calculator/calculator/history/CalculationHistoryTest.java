package calculator.calculator.history;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;
import static org.assertj.core.api.Assertions.*;

class CalculationHistoryTest {

    private final History history = new CalculationHistory();

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {1}")
    @MethodSource("whenHistoryThenSuccessDummy")
    @DisplayName("연산 결과 저장, 조회 성공 테스트")
    void whenFindHistoryThenSuccessTest(List<String> formula, List<String> answer) {
        saveHistories(formula, answer);

        List<String> findAnswersByFindHistories = history.findAllHistories()
                .stream()
                .map(findHistory -> (Map.Entry<String, String>) findHistory)
                .map(Map.Entry::getValue)
                .collect(Collectors.toUnmodifiableList());

        assertThatList(findAnswersByFindHistories).containsAll(answer);
    }

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {0}")
    @MethodSource("whenSaveWrongHistoryThenExceptionDummy")
    @DisplayName("연산 결과 저장 실패 예외처리 테스트")
    void whenSaveWrongHistoryThenExceptionTest(String formula, String answer) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> history.save(formula, answer))
                .withMessageMatching(HISTORY_SAVE_EXCEPTION.getMessage());
    }

    private int saveHistories(List<String> formula, List<String> answer) {
        int expectSize = formula.size();
        IntStream.range(0, expectSize)
                .forEach(curr -> history.save(
                        formula.get(curr),
                        answer.get(curr)
                ));

        return expectSize;
    }

    static Stream<Arguments> whenHistoryThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of("1"),
                        List.of("1")
                ),
                Arguments.arguments(
                        List.of("1", "1 + 2"),
                        List.of("1", "3")
                ),
                Arguments.arguments(
                        List.of("1", "1 + 2", "1 + 2 + 3"),
                        List.of("1", "3", "6")
                ),
                Arguments.arguments(
                        List.of("1", "1 + 2", "1 + 2 + 3", "1 + 2 + 3 + 4", "1 + 2 + 3 + 4 + 5"),
                        List.of("1", "3", "6", "10", "15")
                )
        );
    }

    static Stream<Arguments> whenSaveWrongHistoryThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("1", ""),
                Arguments.arguments("1 + 2", ""),
                Arguments.arguments("1 + 2 + 3", ""),
                Arguments.arguments("1 + 2 - 3", ""),
                Arguments.arguments("1 - 2 + 3", ""),
                Arguments.arguments("1 - 2 - 3", ""),
                Arguments.arguments("1 * 2 * 3", ""),
                Arguments.arguments("1 * 2 / 3", ""),
                Arguments.arguments("1 / 2 * 3", ""),
                Arguments.arguments("1 / 2 / 3", ""),

                Arguments.arguments("", "1"),
                Arguments.arguments("", "10"),
                Arguments.arguments("", "100"),
                Arguments.arguments("", "1000"),

                Arguments.arguments("", "-1"),
                Arguments.arguments("", "-10"),
                Arguments.arguments("", "-100"),
                Arguments.arguments("", "-1000")
        );
    }
}