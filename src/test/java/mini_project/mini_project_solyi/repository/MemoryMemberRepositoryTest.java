package mini_project.mini_project_solyi.repository;

import mini_project.mini_project_solyi.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드가 실행되고 콜백됨 , 데이터 클리어
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("solyi");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("solyi");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("solhee");
        repository.save(member2);

        Member result = repository.findByName("solhee").get();

        assertThat(result).isEqualTo(member2); //assertThat 구문은 어떤 조건이 참인지 확인하는 구문
                                               //isEqualTo 메서드는 대상 내용 자체를 비교한다.
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("solyi");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("solhee");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }



}
