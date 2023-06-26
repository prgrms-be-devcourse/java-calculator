package me.kimihiqq.options;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionTest {

    @Test
    public void shouldReturnCorrectOptionForValidValue() {
        assertEquals(Option.LIST, Option.from("1").orElse(null));
        assertEquals(Option.CALCULATE, Option.from("2").orElse(null));
        assertEquals(Option.EXIT, Option.from("3").orElse(null));
    }

    @Test
    public void shouldReturnEmptyForInvalidValue() {
        assertEquals(Optional.empty(), Option.from("invalid"));
    }
}
