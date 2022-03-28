package calculator;

import calculator.io.Input;
import calculator.io.Output;

import java.io.*;
import java.util.StringTokenizer;

public class Console implements Input, Output {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    @Override
    public String input(String text) throws IOException {
        bw.write(text);
        bw.flush();
        st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    @Override
    public void inputError(String errorMsg) throws IOException {
        bw.write(errorMsg);
        bw.flush();
    }

    @Override
    public void output(String message) throws IOException {
        bw.write(message);
        bw.newLine();
        bw.flush();
    }
}
