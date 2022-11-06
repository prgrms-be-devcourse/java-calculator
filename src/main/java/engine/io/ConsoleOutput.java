package engine.io;

import engine.history.Histories;

import java.util.Map;

public class ConsoleOutput implements Output {

    @Override
    public void printError(String message) {
        System.out.println(message);
    }

    @Override
    public void showHistory(Histories histories) {
        Map<String, String> mapHistories = (Map<String, String>) histories.getHistories();
        String stringHistories = convertToString(mapHistories);
        System.out.println(stringHistories);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private String convertToString(Map<String, String> histories) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String key : histories.keySet()) {
            stringBuilder.append(key + " = ").append(histories.get(key)).append('\n');
        }

        return stringBuilder.toString();
    }
}
