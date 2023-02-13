package com.example.springapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller

public class HelloWebController {
    @GetMapping("/web")
    public String hello(){
        return "hello";
    }
    @GetMapping("/web/message")
    public String message (Model model) {
        model.addAttribute("message"," Hello from BridgeLabz");
        return "message";
    }
}