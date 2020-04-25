package com.example.sharingapp;

public abstract class Command {

    private boolean isExecuted = false;

    public abstract void execute();

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setIsExecuted(boolean executed) {
        isExecuted = executed;
    }
}
