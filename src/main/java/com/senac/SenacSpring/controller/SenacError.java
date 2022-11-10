package com.senac.SenacSpring.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenacError implements ErrorController {

    @RequestMapping("/error")
    public String handleError(){
        return "error";
    }

}
