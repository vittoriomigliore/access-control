package com.accesscontrol.commons.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogsController {


    @GetMapping("/logs")
    public String logs(Model model) {
        return "logs";
    }
}
