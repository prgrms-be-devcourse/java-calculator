package calculator.model.token;

public interface Tokenizationable {
    boolean couldOtherTokenComeNext(Tokenizationable other);
    String getValue(String value);
}
