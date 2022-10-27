package com.project.java.engine.repository;

public class AutoIncrementSequencer implements Sequencer{
    private static int sequence = 0;

    @Override
    public int getSequence() {
        return ++sequence;
    }
}
