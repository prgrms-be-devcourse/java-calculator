import io.Input;
import io.Output;
import option.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Console implements Input,  Output {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public Option selectOption() throws NoSuchElementException, IOException {
        Optional<Option> userOption = Option.getMenu(br.readLine());
        if(userOption.isEmpty()) {
            printInvalidMenuErrorMessage();
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
        System.out.println("조회된 데이터가 없습니다.");
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
    public void printMenuList() {
        Arrays.stream(Option.values()).forEach(o -> System.out.println(o));
    }

    @Override
    public void printInvalidMenuErrorMessage() {
        System.out.println("존재하지 않는 메뉴입니다.");
    }


    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printInputExpressionMessage() {
        System.out.print("계산식을 입력해주세요:");
    }

    @Override
    public void printEmptyInputExpressionMessage() {
        System.out.println("수식을 입력해주세요.");
    }
}
