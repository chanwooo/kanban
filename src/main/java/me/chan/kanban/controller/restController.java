package me.chan.kanban.controller;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class restController {

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/user")
    public String userInfo(Principal principal)
    {
        Member member = memberRepository.findByEmail(principal.getName());
        return "Hi "+member;
    }

}
