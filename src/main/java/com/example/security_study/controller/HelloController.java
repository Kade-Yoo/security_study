package com.example.security_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Objects;

@Controller
public class HelloController {

    @GetMapping("/")
    public String root(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model, Principal principal) {
        if (Objects.isNull(principal)) {
            model.addAttribute("message", "Hello World");
        } else {
            model.addAttribute("message", "Hello World : " + principal.getName());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Info");
        return "info";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        if (Objects.isNull(principal)) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Dashboard " + principal.getName());
        }
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        if (Objects.isNull(principal)) {
            model.addAttribute("message", "Hello Spring Security Admin");
        } else {
            model.addAttribute("message", "Admin " + principal.getName());
        }
        return "admin";
    }
}
