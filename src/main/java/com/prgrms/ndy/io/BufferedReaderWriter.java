package com.prgrms.ndy.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class BufferedReaderWriter implements ReaderWriter {

    private final BufferedReader br;
    private final BufferedWriter bw;

    public BufferedReaderWriter() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public String read() throws IOException {
        return br.readLine();
    }

    @Override
    public void write(String s) throws IOException {
        bw.write(s);
        bw.flush();
    }

    @Override
    public void close() throws IOException {
        br.close();
        bw.close();
    }
}
