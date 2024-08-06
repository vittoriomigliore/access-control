package com.accesscontrol.gatelog.repositories;

import com.accesscontrol.usermanagement.entities.User;
import com.accesscontrol.gatelog.entities.GateLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GateLogRepository extends JpaRepository<GateLog, String> {
    List<GateLog> findByUser(User user);
}
