package com.example.xml.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/homePage")
    public String home() {
        return "homePage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
