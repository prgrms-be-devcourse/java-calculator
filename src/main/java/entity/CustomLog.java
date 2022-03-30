package entity;

public class CustomLog{
    private String log;

    public CustomLog(String expression, String result) {
        this.log = expression + " = " + result;
    }

    @Override
    public String toString() {
        return this.log;
    }
}
