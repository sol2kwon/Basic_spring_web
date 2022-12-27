package mini_project.mini_project_solyi.repository;

import mini_project.mini_project_solyi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스가 인터페이스를 받을때 extends  인터페이스는 다중 상속이 가능하다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
   //jpql select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
