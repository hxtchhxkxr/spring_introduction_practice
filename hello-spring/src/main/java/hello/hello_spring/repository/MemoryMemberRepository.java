package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// @Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // <key, value> 구조
    // 실무에서는 동시성 문제가 있을 수 있어 공유되는 변수일 때는 concurrent HashMap 써야함
    private static long sequence = 0L; // sequence는 0,1,2 같은 키값을 생성해줌
    // 실무에서는 동시성 문제가 있을 수 있어 AtomicLong등을 사용함

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // member에 Id값 세팅, 이름은 넘어온 상태
        store.put(member.getId(), member); // Map에 저장됨
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // store에서 아이디 꺼내기, null이 반환될 가능성이 있어 Optional로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
