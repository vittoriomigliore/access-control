package com.accesscontrol.commons.controllers.ui;

import com.accesscontrol.usermanagement.services.UserService;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilsController {
    private UserService userService;

    UtilsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public String users(@RequestParam("filter") String filter) {
        List<String> userList = userService.userNameList(filter);
        Gson gson = new Gson();
        return gson.toJson(userList);
    }
}
