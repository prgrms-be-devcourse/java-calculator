package org.devcourse.validator;

import org.devcourse.calculator.MenuType;
import org.devcourse.exception.MenuTypeException;

public class MenuValidator<T> implements Validator<T> {

    @Override
    public boolean validate(T menuType) {

        try {

            if (menuType instanceof String) {

                int menuNum = Integer.parseInt((String) menuType);
                return MenuType.hasMenu(menuNum);

            }

        } catch (NumberFormatException e) {
            System.out.println("메뉴 번호를 숫자로 정확히 입력해주세요. [1, 2, 3]");
        } catch (MenuTypeException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

}
