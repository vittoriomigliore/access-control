package com.accesscontrol.gatelog.entities;

public enum GateLogType {
    ENTRANCE,
    EXIT;

    public String getValue() {
        return switch (this) {
            case ENTRANCE -> "Entrance";
            case EXIT -> "Exit";
            default -> null;
        };
    }
}