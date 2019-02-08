package me.chan.kanban;

import me.chan.kanban.domain.Board;
import me.chan.kanban.domain.Section;
import me.chan.kanban.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    @Autowired
    BoardRepository boardRepository;


    @Test
    public void contextLoads() {




        Board board = Board.builder()
                .name("Board1")
                .build();

    //    board.addSection("Todo");

        boardRepository.save(board);

        List<Board> result = boardRepository.findAll();

        for(int i=0; i<result.size(); i++){
            System.out.println("Board name : "+ result.get(i));
//            System.out.println("Section name : "+result.get(i).getSections().size());
        }


    }

}

