package calculator.calculator.history;

import calculator.calculator.formula.Formula;
import calculator.calculator.notation.calculation.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatList;

class CalculationHistoryTest {

    private final History storage = new CalculationHistory();

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {1}")
    @MethodSource("whenSaveHistoryThenSuccessDummy")
    @DisplayName("연산 결과 저장, 조회 성공 테스트")
    void whenFindHistoryThenSuccessTest(List<List<String>> formulas, List<String> answers) {
        saveHistories(formulas, answers);

        List<String> findResults = storage.findAllHistories()
                .values()
                .stream()
                .map(calculationResult ->
                        calculationResult.getResult()
                                .stripTrailingZeros()
                                .toPlainString())
                .collect(Collectors.toUnmodifiableList());

        assertThatList(findResults).containsAll(answers);
    }

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {0}")
    @MethodSource("whenSaveHistoryThenExceptionDummy")
    @DisplayName("연산 결과 저장 실패 예외처리 테스트")
    void whenSaveWrongHistoryThenExceptionTest(List<List<String>> formulas, List<String> answers) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> saveHistories(formulas, answers))
                .withMessageMatching(HISTORY_SAVE_EXCEPTION.getMessage());
    }

    private void saveHistories(List<List<String>> formulas, List<String> results) {
        List<Formula> parsedFormulas = formulas.stream()
                .map(Formula::new)
                .collect(Collectors.toList());

        List<CalculationResult> parsedResults = results.stream()
                .map(result -> new CalculationResult(new BigDecimal(result)))
                .collect(Collectors.toList());

        IntStream.range(0, formulas.size())
                .mapToObj(curr -> new CalculationHistoryForm(
                        parsedFormulas.get(curr),
                        parsedResults.get(curr)))
                .forEach(storage::save);
    }

    static Stream<Arguments> whenSaveHistoryThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(List.of("1", "+", "2")),
                        List.of("3")
                ),
                Arguments.arguments(
                        List.of(List.of("1", "-", "2")),
                        List.of("-1")
                ),
                Arguments.arguments(
                        List.of(List.of("1", "*", "2")),
                        List.of("2")
                ),
                Arguments.arguments(
                        List.of(List.of("1", "*", "2", "/", "2", "+", "2")),
                        List.of("3")
                ),
                Arguments.arguments(
                        List.of(
                                List.of("1", "+", "2"),
                                List.of("1", "-", "2"),
                                List.of("1", "*", "2"),
                                List.of("1", "*", "2", "/", "2", "+", "2")),
                        List.of("3", "-1", "2", "3")
                )
        );
    }

    static Stream<Arguments> whenSaveHistoryThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(List.of("1", "+", "2")),
                        List.of("")
                ),
                Arguments.arguments(
                        List.of(List.of("")),
                        List.of("3")
                ),
                Arguments.arguments(
                        List.of(List.of("1", "*", "2", "/", "2", "+", "2")),
                        List.of("")
                )
        );
    }
}