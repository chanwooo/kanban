package me.chan.kanban.controller;

import me.chan.kanban.domain.Board;
import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.BoardRepository;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BoardRepository boardRepository;

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
    public String boards(Model model, Principal principal)
    {
        Member member = memberRepository.findByEmail(principal.getName());
        Board board = boardRepository.findByOwner(member);

        //System.out.println(board.getName()+" "+board.getOwner().getNickName());

        //System.out.println(board.getName());

        model.addAttribute("user", member);
        model.addAttribute("boards", board);



        return "boardlist";
    }




}
