package me.chan.kanban.controller;

import me.chan.kanban.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public String login(Member member) {
//        System.out.println("login");
//        return "index";
//    }


    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Member member) {
        System.out.println("register");
        return "redirect:/";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(Member user) {
        return "redirect:/boards";
    }
}
