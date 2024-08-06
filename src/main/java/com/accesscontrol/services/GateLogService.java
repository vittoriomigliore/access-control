package com.accesscontrol.services;

import com.accesscontrol.entities.GateLog;
import com.accesscontrol.entities.GateLogType;
import com.accesscontrol.entities.User;
import com.accesscontrol.repositories.GateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class GateLogService {

    private final GateLogRepository gateLogRepository;

    @Autowired
    public GateLogService(GateLogRepository gateLogRepository) {
        this.gateLogRepository = gateLogRepository;
    }

    public GateLog saveGateLog(User user) {
        List<GateLog> logs = findGateLogsByUser(user);
        GateLogType type = nextUserLogType(logs);
        return saveGateLog(user, type);
    }

    private GateLog saveGateLog(User user, GateLogType type) {
        GateLog gateLog = new GateLog();
        gateLog.setUser(user);
        gateLog.setType(type);
        gateLog.setTimestamp(LocalDateTime.now());
        return gateLogRepository.save(gateLog);
    }

    public List<GateLog> findGateLogsByUser(User user) {
        return gateLogRepository.findByUser(user);
    }

    public GateLogType nextUserLogType(List<GateLog> gateLogList) {
        if (gateLogList.isEmpty()) {
            return GateLogType.ENTRANCE;
        }
        if (gateLogList.stream().map(GateLog::getUser).distinct().count() != 1) {
            throw new IllegalArgumentException("All logs must have the same user");
        }
        List<GateLog> sortedList = gateLogList.stream().sorted(Comparator.comparing(GateLog::getTimestamp)).toList();
        return sortedList.get(sortedList.size() - 1).getType() == GateLogType.ENTRANCE ? GateLogType.EXIT : GateLogType.ENTRANCE;
    }
}
