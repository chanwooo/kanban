package me.chan.kanban;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
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
    public CommandLineRunner runner(MemberRepository memberRepository) throws Exception {
        return (args) -> {
            Member user = memberRepository.save(Member.builder()
            .mail("chanwookim@me.com")
            .password("cksdn1")
            .nickName("찬우")
            .createdDate(LocalDateTime.now())
            .build()
            );
        };
    }

}

