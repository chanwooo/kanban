package me.chan.kanban.controller;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    MemberRepository userRepository;

    @GetMapping({"","/"})
    public String hello()
    {
        return "index";
    }

    @GetMapping("/test")
    public String test()
    {
        return "index";
    }

    @GetMapping("/board")
    public String boards(Model model, Member user)
    {
        model.addAttribute("user", user);
        return "boardlist";
    }




}
