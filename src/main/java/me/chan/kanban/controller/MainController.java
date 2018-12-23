package me.chan.kanban.controller;

import me.chan.kanban.domain.User;
import me.chan.kanban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

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
    @GetMapping("/boards")
    public String boards(Model model,@AuthenticationPrincipal User user)
    {
        model.addAttribute("user", user);
        return "boardlist";
    }




}
