package option;

public enum Option {
    HISTORY("1","조회"),
    CAL("2","계산");

    private final String opt;
    private final String idx;

    Option(String opt, String idx) {
        this.opt = opt;
        this.idx = idx;
    }
}
