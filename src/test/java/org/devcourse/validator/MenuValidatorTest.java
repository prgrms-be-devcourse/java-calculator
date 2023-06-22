package org.devcourse.validator;

import org.assertj.core.api.Assertions;
import org.devcourse.calculator.MenuType;
import org.devcourse.exception.MenuTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuValidatorTest {


    @ParameterizedTest
    @DisplayName("올바른 메뉴 입력")
    @ValueSource(
            strings = {"1", "2", "3"}

    )
    void correctInputMenu(String menu) {


        Validator<String> inputMenuValidator = (String s) -> {

            try {

                int menuNum = Integer.parseInt(s);
                return MenuType.hasMenu(menuNum);

            } catch (NumberFormatException e) {
                System.out.println("메뉴 번호를 숫자로 정확히 입력해주세요. [1, 2, 3]");
            } catch (MenuTypeException e) {
                System.out.println(e.getMessage());
            }

            return false;
        };

        boolean isValid = inputMenuValidator.validate(menu);
        Assertions.assertThat(isValid).isEqualTo(true);

    }


    @ParameterizedTest
    @DisplayName("올바른 메뉴 입력")
    @ValueSource(
            strings = {"4", "hi", "123"}

    )
    void wrongInputMenu(String menu) {


        Validator<String> inputMenuValidator = (String s) -> {

            try {

                int menuNum = Integer.parseInt(s);
                return MenuType.hasMenu(menuNum);

            } catch (NumberFormatException e) {
                System.out.println("메뉴 번호를 숫자로 정확히 입력해주세요. [1, 2, 3]");
            } catch (MenuTypeException e) {
                System.out.println(e.getMessage());
            }

            return false;
        };

        boolean isValid = inputMenuValidator.validate(menu);
        Assertions.assertThat(isValid).isEqualTo(false);

    }



}
