package com.prgrms.ndy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

public class Calculation {

    private final Command command;
    private final Number result;
    private final LocalDateTime createdDate;

    public Calculation(Command command, Number result) {
        this.command = command;
        this.result = result;
        this.createdDate = LocalDateTime.now();
    }

    public Command getCommand() {
        return command;
    }

    public Number getResult() {
        return result;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("command", command)
                .append("result", result)
                .append("createdDate", createdDate)
                .toString();
    }
}
