package com.accesscontrol.controllers.api;

import com.accesscontrol.entities.GateLog;
import com.accesscontrol.entities.User;
import com.accesscontrol.services.GateLogService;
import com.accesscontrol.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gatelogs")
public class GateLogController {
    private final GateLogService gateLogService;
    private final UserService userService;

    @Autowired
    public GateLogController(GateLogService gateLogService, UserService userService) {
        this.gateLogService = gateLogService;
        this.userService = userService;
    }

    @PostMapping("/log")
    public GateLog saveLog(@RequestParam Long userId) {
        User user = userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return gateLogService.saveGateLog(user);
    }

    @GetMapping("/{userId}")
    public List<GateLog> getUserGateLogs(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return gateLogService.findGateLogsByUser(user);
    }
}
