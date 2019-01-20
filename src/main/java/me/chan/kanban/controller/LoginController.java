package me.chan.kanban.controller;

import me.chan.kanban.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(Member user) {
        return "redirect:/boards";
    }
}
