package calculator.service;

import static calculator.view.OutputView.showAllHistory;
import static calculator.view.OutputView.showEmptyHistoryMessage;

import calculator.storage.HistoryStorage;

public class HistoryReader {

    private static final int EMPTY_LENGTH = 0;

    private final HistoryStorage historyStorage;

    public HistoryReader(HistoryStorage historyStorage) {
        this.historyStorage = historyStorage;
    }

    public void execute() {
        String[] allHistory = historyStorage.readAllHistory();

        if (allHistory.length == EMPTY_LENGTH) {
            showEmptyHistoryMessage();

            return;
        }

        showAllHistory(allHistory);
    }
}
