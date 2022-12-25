package mini_project.mini_project_solyi.service;

import mini_project.mini_project_solyi.domain.Member;
import mini_project.mini_project_solyi.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private  final MemberRepository memberRepository;

    //DI, 직접 memberRepository 넣어줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * 중복된 회원이름이 있으면 안됨
     * */
    
    public Long join(Member member) {
        validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers(){
      return  memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }
}
