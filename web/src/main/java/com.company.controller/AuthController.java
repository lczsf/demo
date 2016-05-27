package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wb-lichao.x on 2016/5/25.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    @RequestMapping("/login")
    public String authLogin() {
        return "jsp/auth/login";
    }

    @RequestMapping("/loginOn")
    public String authLoginOn(@RequestParam("name") String name, @RequestParam(value = "password") String password) {
        if (name != null)
            return "index";
        else
            return "fail";
    }
}
