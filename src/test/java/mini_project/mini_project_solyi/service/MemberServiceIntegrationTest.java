package mini_project.mini_project_solyi.service;

import mini_project.mini_project_solyi.domain.Member;
import mini_project.mini_project_solyi.repository.MemberRepository;
import mini_project.mini_project_solyi.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        //given 어떤 상황이 주어져서
        Member member = new Member();
        member.setName("잘설정되었는가");

        //when 어떻게 했을때
        Long saveId = memberService.join(member);

        //then 결과가 나와야함
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void joinException() {
        //given 어떤 상황이 주어져서
        Member member1 = new Member();
        member1.setName("solyi");

        Member member2 = new Member();
        member2.setName("solyi");

        //when 어떻게 했을때
        memberService.join(member1);
        IllegalStateException e =  assertThrows(IllegalStateException.class,() -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}