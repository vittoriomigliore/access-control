package com.accesscontrol.controllers;

import com.accesscontrol.entities.GateLog;
import com.accesscontrol.entities.GateLogType;
import com.accesscontrol.entities.User;
import com.accesscontrol.services.GateLogService;
import com.accesscontrol.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LogsController {

    private final GateLogService gateLogService;
    private final UserService userService;

    private GateLogType nextLogType;

    public LogsController(GateLogService gateLogService, UserService userService) {
        this.gateLogService = gateLogService;
        this.userService = userService;
    }

    @GetMapping("/logs")
    public String getUserLogs(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<GateLog> logs = gateLogService.findGateLogsByUser(user);

        nextLogType = gateLogService.nextUserLogType(logs);

        model.addAttribute("gateLogs", logs);
        model.addAttribute("nextLogType", nextLogType);

        return "logs";
    }

    @PostMapping("/makeLog")
    public String addLog() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userService.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));

        gateLogService.saveGateLog(user, nextLogType);

        return "redirect:/logs";
    }
}
