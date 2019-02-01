package me.chan.kanban;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BootApplication {

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
            List<Member> list = memberRepository.findAll();
            System.out.println("---- command line runner log ----");
            System.out.println("SIZE : "+list.size());
            for(int i=0; i<list.size(); i++) {
                //System.out.println(list.get(i).getIdx()+"->"+list.get(i).getNickName());
                System.out.println(list.get(i).toStringDetail());
            }

            System.out.println("---------------------------------");



        };
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}