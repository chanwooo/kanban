package me.chan.kanban;

import me.chan.kanban.domain.User;
import me.chan.kanban.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository) throws Exception {
        return (args) -> {
            User user = userRepository.save(User.builder()
            .mail("chanwookim@me.com")
            .password("cksdn1")
            .nickName("찬우")
            .createdDate(LocalDateTime.now())
            .build()
            );
        };
    }

}

