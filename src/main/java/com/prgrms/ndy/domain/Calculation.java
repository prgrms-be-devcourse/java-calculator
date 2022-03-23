package com.prgrms.ndy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.Objects;

public class Calculation {

    private Long id;
    private final Command command;
    private final Number result;
    private final LocalDateTime createdAt;

    public Calculation(Command command, Number result) {
        this.command = command;
        this.result = result;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Command getCommand() {
        return command;
    }

    public Number getResult() {
        return result;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("command", command)
                .append("result", result)
                .append("createdAt", createdAt)
                .toString();
    }

    public String display() {
        return new StringBuilder()
                .append(command).append(" = ").append(result)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculation that = (Calculation) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, result, createdAt);
    }
}
