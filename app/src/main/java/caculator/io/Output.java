package caculator.io;

import java.util.ArrayList;

public interface Output {
    public void print(ArrayList<StringBuilder> list);

    public void print(String msg);

    public void print(float msg);
}
