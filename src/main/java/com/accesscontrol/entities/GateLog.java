package com.accesscontrol.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "gates_logs")
public class GateLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Gate gate = Gate.MAIN;
    @Enumerated(EnumType.STRING)
    private GateLogType type;
    @ManyToOne
    private User user;
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public GateLogType getType() {
        return type;
    }

    public void setType(GateLogType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
