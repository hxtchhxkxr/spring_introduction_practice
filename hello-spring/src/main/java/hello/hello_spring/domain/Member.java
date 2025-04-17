package hello.hello_spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// JPA가 관리하는 Entity
public class Member {

    @Id // PK(primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity : query에 id 넣는 것이 아닌 db에 값을 넣음
    private Long id;
    // 고객이 정하는 아이디가 아닌 시스템이 저장하는 아이디

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
