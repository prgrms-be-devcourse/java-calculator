package com.programmers.cal.engine.exit;

import com.programmers.cal.engine.io.Message;

public class ExitManager implements Exit {
    @Override
    public Message getExitMessage() {
        return Message.EXIT_MESSAGE;
    }
}
