package Result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INVALID_MENU_NUMBER(400, "MENU-001", "잘못된 메뉴번호를 입력하였습니다"),
    INVALID_EXPRESS(400, "EXPRESS-001", "유효하지 않은 수식입니다."),
    INVALID_DIVIDE_ZERO(400, "EXPRESS-002", "0으로는 나눌 수 없습니다."),
    INVALID_ENUM_TYPE(400, "ENUM-001", "지원하지 않는 Enum타입 입니다.");

    private final int status;
    private final String codeName;
    private final String message;

}
