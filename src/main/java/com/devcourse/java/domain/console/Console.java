package com.devcourse.java.domain.console;

import com.devcourse.java.domain.console.io.Reader;
import com.devcourse.java.domain.console.io.Writer;

import java.util.Collection;

public class Console {
    private static final String MENU_SELECTION = "1: 조회\n2: 계산\n\n선택 : ";
    private static final String EXIT_CONFIRM = "메뉴에 없는 값을 입력했습니다.\n종료하시겠습니까? (Y) : ";
    private final Reader reader;
    private final Writer writer;

    public Console(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String selectMenu() {
        writer.write(MENU_SELECTION);
        return reader.read();
    }

    public String confirmExiting() {
        writer.write(EXIT_CONFIRM);
        return reader.read();
    }

    public String read() {
        return reader.read();
    }

    public <T> void write(T message) {
        if (isCollection(message)) {
            writeCollection(message);
            return;
        }
        
        writer.write(message);
    }

    private <T> boolean isCollection(T message) {
        return message instanceof Collection<?>;
    }

    private <T> void writeCollection(T message) {
        ((Collection<?>) message).forEach(this::write);
    }
}
