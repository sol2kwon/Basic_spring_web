package mini_project.mini_project_solyi.service;

import mini_project.mini_project_solyi.aop.TimeTraceAop;
import mini_project.mini_project_solyi.repository.JpaMemberRepository;
import mini_project.mini_project_solyi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration // 가장 먼저 읽음
public class SpringConfig {

    @Autowired //생성자가 한개인 경우 생략 가능하다.
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }


//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository); //서비스->레포짓토리 연결
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop(); // TimeTraceAop에 @Component 해줘도 되지만 직접 @Bean 등록 해주는걸 선호
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
