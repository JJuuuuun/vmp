package com.toyproject.vending_machine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/docs")
    public String swagger() {
        return "redirect:/swagger-ui/";
    }
}
