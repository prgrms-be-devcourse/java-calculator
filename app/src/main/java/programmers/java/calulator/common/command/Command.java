package programmers.java.calulator.common.command;

import programmers.java.calulator.common.command.factory.CommandType;

public interface Command {
    void execute();
    CommandType getCommandType();
}
