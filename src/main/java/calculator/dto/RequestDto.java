package calculator.dto;

public class RequestDto {
    private Integer request;
    private String expr;

    public void setRequest(Integer request) {
        this.request = request;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public Integer getRequest() {
        return request;
    }

    public String getExpr() {
        return expr;
    }
}
