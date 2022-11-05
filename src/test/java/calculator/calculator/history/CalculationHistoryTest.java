package calculator.calculator.history;

import calculator.calculator.formula.Formula;
import calculator.calculator.notation.calculation.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;
import static calculator.exception.HistoryException.HISTORY_SAVE_OVERLAP_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatList;

class CalculationHistoryTest {

    private static final History storage = new CalculationHistory();

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {1}")
    @MethodSource("whenSaveHistoryThenSuccessDummy")
    @DisplayName("연산 결과 저장, 조회 성공 테스트")
    void whenFindHistoryThenSuccessTest(List<List<String>> formulas, List<String> answers) {
        saveHistories(formulas, answers);

        List<String> findResults = storage.findAllHistories()
                .values()
                .stream()
                .map(CalculationResult::getResult)
                .collect(Collectors.toUnmodifiableList());

        assertThatList(findResults).containsAll(answers);
    }

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {1}")
    @MethodSource("whenSaveHistoryThenExceptionDummy")
    @DisplayName("연산 결과 저장 실패 예외처리 테스트")
    void whenSaveWrongHistoryThenExceptionTest(List<List<String>> formulas, List<String> answers) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> saveHistories(formulas, answers))
                .withMessageMatching(HISTORY_SAVE_EXCEPTION.getMessage());
    }

    @ParameterizedTest(name = "[{index}] formula = {0}, answer = {1}")
    @MethodSource("whenSaveOverlapHistoryThenExceptionDummy")
    @DisplayName("연산식 중복 저장 실패 예외처리 테스트")
    void whenSaveOverlapHistoryThenExceptionTest(List<List<String>> formulas, List<String> answers) {
        Formula formula = new Formula(formulas.get(0));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> saveOverlapHistory(formula, answers))
                .withMessageMatching(HISTORY_SAVE_OVERLAP_EXCEPTION.getMessage());
    }

    private static void saveOverlapHistory(Formula formula, List<String> answers) {
        answers.stream()
                .map(answer -> new CalculationHistoryForm(formula, new CalculationResult(answer)))
                .forEach(storage::save);
    }

    private void saveHistories(List<List<String>> formulas, List<String> results) {
        List<Formula> parsedFormulas = formulas.stream()
                .map(Formula::new)
                .collect(Collectors.toList());

        List<CalculationResult> parsedResults = results.stream()
                .map(CalculationResult::new)
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
                        List.of(" ")
                ),
                Arguments.arguments(
                        List.of(List.of("")),
                        List.of("3")
                ),
                Arguments.arguments(
                        List.of(List.of("1", "*", "2", "/", "2", "+", "2")),
                        List.of(" ")
                )
        );
    }

    static Stream<Arguments> whenSaveOverlapHistoryThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(List.of("1", "+", "2")),
                        List.of("3", "3", "3", "3", "3")),
                Arguments.arguments(
                        List.of(List.of("1", "-", "2")),
                        List.of("-1", "-1", "-1", "-1", "-1")),
                Arguments.arguments(
                        List.of(List.of("1", "*", "2")),
                        List.of("2", "2", "2", "2", "2")
                )
        );
    }
}