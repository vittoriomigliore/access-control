package com.accesscontrol.repositories;

import com.accesscontrol.entities.GateLog;
import com.accesscontrol.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GateLogRepository extends JpaRepository<GateLog, String> {
    List<GateLog> findByUser(User user);
}
