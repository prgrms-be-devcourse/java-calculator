import java.util.LinkedList;
import java.util.Queue;

public class Memorizer {

    private static Memorizer memorizer = new Memorizer();

    private Queue<String> history;
    private Memorizer() {
        this.history = new LinkedList<>();
    }

    public static Memorizer getInstance() {
        return memorizer;
    }

    public void save(String result) {
        history.add(result);
    }

    public void show() {
        int times = history.size();

        if(times == 0) {
            System.out.println("there is no history..");
            return;
        }

        while(times > 0) {
            String result = history.poll();
            System.out.println(result);
            times--;
            history.add(result);
        }
    }
}
