package com.accesscontrol.commons.controllers.ui;

import com.accesscontrol.gatelog.entities.GateLog;
import com.accesscontrol.gatelog.entities.GateLogType;
import com.accesscontrol.usermanagement.entities.User;
import com.accesscontrol.gatelog.services.GateLogService;
import com.accesscontrol.usermanagement.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final GateLogService gateLogService;
    private final UserService userService;

    public HomeController(GateLogService gateLogService, UserService userService) {
        this.gateLogService = gateLogService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        LocalDate now = LocalDate.now();
        List<GateLog> gateLogList = gateLogService.findGateLogsByUser(userService.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found")));
        GateLogType nextLogType = gateLogService.nextUserLogType(gateLogList);
        model.addAttribute("username", username);
        model.addAttribute("now", now);
        model.addAttribute("gateLogs", gateLogList);
        model.addAttribute("nextLogType", nextLogType);
        return "dashboard";
    }

    @PostMapping("/saveLog")
    public String saveLog() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userService.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));

        gateLogService.saveGateLog(user);

        return "redirect:/";
    }

    @GetMapping("/deleteLog")
    public String deleteLog(@RequestParam("id") Long gateLogId) {
        gateLogService.deleteGateLogById(gateLogId);

        return "redirect:/";
    }

}
