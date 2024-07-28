package com.accesscontrol.services;

import com.accesscontrol.entities.GateLog;
import com.accesscontrol.entities.GateLogType;
import com.accesscontrol.entities.User;
import com.accesscontrol.repositories.GateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GateLogService {

    private final GateLogRepository gateLogRepository;

    @Autowired
    public GateLogService(GateLogRepository gateLogRepository) {
        this.gateLogRepository = gateLogRepository;
    }

    public GateLog saveGateLog(User user, GateLogType type) {
        GateLog gateLog = new GateLog();
        gateLog.setUser(user);
        gateLog.setType(type);
        gateLog.setTimestamp(LocalDateTime.now());
        return gateLogRepository.save(gateLog);
    }

    public List<GateLog> findGateLogsByUser(User user) {
        return gateLogRepository.findByUser(user);
    }
}
