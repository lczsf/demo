package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-lichao.x on 2016/4/23.
 */

@Controller
@RequestMapping(value="/book")
public class BookController {

    @RequestMapping(value="/title")
    public String getTitle(){
        return "title";
    }

    @RequestMapping(value="/content")
    public String getContent(){
        return "content";
    }
}
