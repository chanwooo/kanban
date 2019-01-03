package me.chan.kanban.controller;

import me.chan.kanban.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    @GetMapping("/user")
    public String userInfo(Member user)
    {
        return user.toString();
    }

}
