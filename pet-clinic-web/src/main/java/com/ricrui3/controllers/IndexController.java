package com.ricrui3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By ricardo.ruiz
 */
@Controller
public class IndexController {

    @RequestMapping({"","/", "index", "index.html"})
    public String index(){
        return "index";
    }
}
