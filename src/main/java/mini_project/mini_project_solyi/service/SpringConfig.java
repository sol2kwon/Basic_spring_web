package mini_project.mini_project_solyi.service;

import mini_project.mini_project_solyi.repository.MemberRepository;
import mini_project.mini_project_solyi.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 가장 먼저 읽음
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository()); //서비스->레포짓토리 연결
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
