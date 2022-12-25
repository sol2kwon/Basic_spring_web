package mini_project.mini_project_solyi.repository;

import mini_project.mini_project_solyi.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원저장
    Optional<Member> findById(Long id);//id 찾음
    Optional<Member> findByName(String name); //name 찾음
    List<Member> findAll();// 모든 회원리스트 반환
    void clearStore();

}
