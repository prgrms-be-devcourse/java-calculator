import com.calculator.common.BusinessException;
import com.calculator.common.MenuType;
import com.calculator.common.ValidatorHandler;
import com.calculator.io.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.calculator.common.ExceptionStatus.INPUT_TYPE_ERROR;
import static com.calculator.common.ExceptionStatus.NOT_NUM_ERROR;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateTest {

    ValidatorHandler validatorHandler = new ValidatorHandler();

    @Test
    @DisplayName("입력 계산식 오류")
    void inputError() {
        try {
            String input = "a + 1";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            validatorHandler.inputError(input);
        } catch (BusinessException e) {
            assertThat(e.getMessage()).isEqualTo(NOT_NUM_ERROR.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "="})
    @DisplayName("메뉴 타입 입력 오류")
    void menuError(String type) {
        try {
            MenuType.of(type);
        } catch (BusinessException e) {
            assertThat(e.getMessage()).isEqualTo(INPUT_TYPE_ERROR.getMessage());
        }
    }
}
