package mini_project.mini_project_solyi.repository;

import mini_project.mini_project_solyi.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); //key는 long value는 member 저장
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);//저장될때마다 id 셋팅
        store.put(member.getId(),member); //store 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //findany 하나라도 찾으면 반환, 루프 다 돌았는데 없으면 옵셔널에 널포함하여 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 밸류는 멤버들
    }

    public void clearStore(){
        store.clear();
    }
}
