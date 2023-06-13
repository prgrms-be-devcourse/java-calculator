
import io.Input;
import io.Output;
import option.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Console implements Input,  Output {
    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //사용자가 1번(조회)를 선택하였을 시 실행
    @Override
    public Option selectOption() throws NoSuchElementException {
        Optional<Option> userOption = Option.getMenu(sc.nextLine());
        if(userOption.isEmpty()) {
            System.out.println("존재하지 않는 메뉴입니다.");
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
    public void ShowOptions() {
        Arrays.stream(Option.values()).forEach(o -> System.out.println(o.toString()));
    }


    @Override
    public void printResult(Integer result) {
        System.out.println(result);
    }

    @Override
    public void quitMessage() {

    }
}
