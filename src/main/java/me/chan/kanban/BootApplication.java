package me.chan.kanban;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import me.chan.kanban.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class BootApplication {

    @Autowired
    MemberService memberService;

    public static void main(String[] args) { SpringApplication.run(BootApplication.class, args); }



    @Bean
    public CommandLineRunner runner(MemberRepository memberRepository) throws Exception {
        return args -> {
            memberRepository.save(Member.builder()
                    .email("chanwookim@me.com")
                    .password(passwordEncoder().encode("cksdn1"))
                    .nickName("찬우")
                    .createdDate(LocalDateTime.now())
                    .build()
            );
            //System.out.println(m.getName()+" "+m.getEmail());
            memberService.printAll();

        };
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}