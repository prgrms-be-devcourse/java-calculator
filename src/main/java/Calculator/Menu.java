package Calculator;

import Config.EnumInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Menu implements EnumInterface {
    RECORD("1"), CALC("2"), EXIT("3");

    private final String type;

    public static Menu getManual (String type) {
        return EnumInterface.find(type, values());
    }
}
