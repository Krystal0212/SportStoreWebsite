package com.ESDC.FinalTerm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Return the name of the login.html template
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Return the name of the register.html template
    }

    @GetMapping("/shoesCategory")
    public String shoesCategoryPage() {
        return "shoesCategory"; // Return the name of the register.html template
    }
}
