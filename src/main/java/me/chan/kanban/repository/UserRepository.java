package me.chan.kanban.repository;

import me.chan.kanban.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByMail(String mail);
}
