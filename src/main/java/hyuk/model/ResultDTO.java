package hyuk.model;

import hyuk.calculator.Result;

public class ResultDTO {

    private int result;

    public ResultDTO(Result result) {
        this.result = result.showResult();
    }

    public int getResult() {
        return result;
    }
}
