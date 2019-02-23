package me.chan.kanban.service;

import me.chan.kanban.domain.Board;
import me.chan.kanban.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Transactional
    public void printAll(){
        List<Board> list = boardRepository.findAll();

        System.out.println("---- command line runner log ----");
        System.out.println("Size of Repository : member : "+list.size());
        for(int i=0; i<list.size(); i++) {
            //System.out.println(list.get(i).getIdx()+"->"+list.get(i).getNickName());
            System.out.println(list.get(i));
        }
        System.out.println("---------------------------------");
    }

}
