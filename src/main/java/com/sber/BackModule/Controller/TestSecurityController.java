package com.sber.BackModule.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TestSecurityController {

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }
}