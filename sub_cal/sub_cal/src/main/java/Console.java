
import io.Input;
import io.Output;
import option.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static global.ErrorMessage.HISTORY_EMPTY_MESSAGE;
import static global.ErrorMessage.INVALID_MENU_INDEX;

public class Console implements Input,  Output {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //사용자가 1번(조회)를 선택하였을 시 실행
    @Override
    public Option selectOption() throws NoSuchElementException, IOException {
        Optional<Option> userOption = Option.getMenu(br.readLine());
        if(userOption.isEmpty()) {
            System.out.println(INVALID_MENU_INDEX);
        }

        return userOption.get();
    }

    @Override
    public String inputString() throws IOException {
        String input = br.readLine();
        return input;
    }

    @Override
    public void inputEmptyError(String inputString) {
        System.out.println(inputString);
    }

    @Override
    public void historyEmptyError() {
        System.out.println(HISTORY_EMPTY_MESSAGE);
    }

    @Override
    public boolean showResultHistory(List<String> historyList) {
        if(historyList.isEmpty()) return false;
        for (String s : historyList) {
            System.out.println(s);
        }

        return true;
    }

    @Override
    public void ShowOptions() {
        Arrays.stream(Option.values()).forEach(o -> System.out.println(o.toString()));
    }


    @Override
    public void printResult(Integer result) {
        System.out.println(result);
    }
}
