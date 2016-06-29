package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-lichao.x on 2016/5/25.
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "user";
    }

    @RequestMapping(value = "common")
    public String common() {
        return "common";
    }
}
