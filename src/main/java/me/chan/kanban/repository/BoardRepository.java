package me.chan.kanban.repository;

import me.chan.kanban.domain.Board;
import me.chan.kanban.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByIdx(Long idx);
    Board findByOwner(Member m);

}
