package org.programmers.service.IO;

import org.programmers.entity.ResultModel;

import java.util.List;

public interface Output {

    void printMenu();

    void printResult(double result);

    void historyInquiry(List<ResultModel> history);

    void inputNumError();

    void inputExError(int i);
}
