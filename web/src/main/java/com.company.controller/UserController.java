package com.company.controller;

import com.company.common.Page;
import com.company.common.PageVo;
import com.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by wb-lichao.x on 2016/5/13.
 * http://localhost:8080/web/user/queryPage
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/queryPage", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Page queryPage(@RequestBody(required = true) PageVo pageVo) {
        Page page = new Page(pageVo.getPageNum(), pageVo.getPageSize());
        return userService.queryPage(page);
    }
}
