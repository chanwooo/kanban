package me.chan.kanban.service;

import me.chan.kanban.domain.Member;
import me.chan.kanban.repository.MemberRepository;
import me.chan.kanban.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void printAll(){
        List<Member> list = memberRepository.findAll();

        System.out.println("---- command line runner log ----");
        System.out.println("Size of Repository : member : "+list.size());
        for(int i=0; i<list.size(); i++) {
            //System.out.println(list.get(i).getIdx()+"->"+list.get(i).getNickName());
            System.out.println(list.get(i).toStringDetail());
        }
        System.out.println("---------------------------------");
    }

    @Transactional
    public void save(Member m){
        m.setPassword(passwordEncoder.encode(m.getPassword()));
        memberRepository.save(m);
    }



}
