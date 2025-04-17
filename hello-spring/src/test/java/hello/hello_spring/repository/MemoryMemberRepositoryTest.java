package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // 해당 라이브러리 추가해야 assertThat 사용 가능

// 다른데서 쓸 필요 없으니 굳이 public 안해도 됨
class MemoryMemberRepositoryTest {

    // MemberRepository repository = new MemoryMemberRepository();
    MemoryMemberRepository repository = new MemoryMemberRepository();
    // afterEach 사용 위해 인터페이스 -> 클래스 변환

    @AfterEach // 메소드가 실행이 끝날 때마다 동작을 하는 콜백 메소드
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    //save 기능 동작하는지 test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        // Optional에서 값을 꺼낼 때는 get으로 할 수 있음
        Member result = repository.findById(member.getId()).get();

        // System.out.println("result = " + (result == member));

        // Assertions.assertEquals(member, result); // (expected, actual)
        // org.junit.jupiter.api에서 제공

         assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        // result.size() == 2임
    }
}
