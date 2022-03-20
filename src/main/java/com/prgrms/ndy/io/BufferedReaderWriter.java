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
    public String read() {
        try {
            return br.readLine();
        } catch (IOException e) {
            log.debug("[IOException] - BufferedReaderWriter.read ", e);
        }
        return null;
    }

    @Override
    public void write(String s) {
        try {
            bw.write(s);
            bw.flush();
        } catch (IOException e) {
            log.debug("[IOException] - BufferedReaderWriter.write(s = {}) ", s, e);
        }
    }

    @Override
    public void close() {
        try {
            br.close();
            bw.close();
        } catch (IOException e) {
            log.debug("[IOException] - BufferedReaderWriter.close", e);
        }
    }
}
