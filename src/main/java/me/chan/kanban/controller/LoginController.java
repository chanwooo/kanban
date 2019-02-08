package me.chan.kanban.controller;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import me.chan.kanban.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Member member) {
        //System.out.println(member.toStringDetail());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);

        memberService.printAll();

        return "redirect:/";
    }
}
