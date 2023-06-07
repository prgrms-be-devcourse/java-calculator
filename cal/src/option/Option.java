package option;

public enum Option {
    HISTORY("1","조회"),
    CAL("2","계산");

    private final String opt;
    private final String idx;

    Option(String idx, String opt) {
        this.opt = opt;
        this.idx = idx;
    }

    public String getOpt() {
        return opt;
    }

    public String getIdx() {
        return idx;
    }
}
