package Config;

import Result.ErrorCode;

import java.util.Arrays;

public interface EnumInterface {
    String getType();
    static <T extends EnumInterface> T find(String type, T[] values) {
        return Arrays.stream(values)
                .filter(value -> value.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorCode.INVALID_ENUM_TYPE.getMessage()));
    }
}
