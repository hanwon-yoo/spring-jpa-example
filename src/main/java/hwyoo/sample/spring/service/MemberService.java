package hwyoo.sample.spring.service;

import hwyoo.sample.spring.entity.Member;
import hwyoo.sample.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by hanwon.yoo on 2018. 7. 25..
 */

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void addMember() {
        Member member = new Member();
        member.setName("유한원");
        member.setAge(30);
        memberRepository.save(member);
    }

    public List<Member> getAllMembers(){
        return StreamSupport.stream(memberRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
