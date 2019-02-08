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
    MemberService memberService;


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


    //email이 unique이기 때문에 중복된 email로 회원가입시 적절한 예외처리 필요 현재는 에러 발생.
    @PostMapping("/register")
    public String register(Member member) {
        //System.out.println(member.toStringDetail());
        memberService.save(member);
        memberService.printAll();

        return "redirect:/";
    }
}
