package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import  java.util.Optional;
// Optional 클래스는 java.util 패키지에 포함되어 있음

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장됨
    Optional<Member> findById(Long id); // 저장소에서 찾아옴
    Optional<Member> findByName(String name); // 저장소에서 찾아옴
    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트를 반환함
}
