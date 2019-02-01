package me.chan.kanban.repository;

import me.chan.kanban.domain.Board;
import me.chan.kanban.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
