package com.app.foodverse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = "/signin")
    public String getLogin() {
        return "login";
    }

}
