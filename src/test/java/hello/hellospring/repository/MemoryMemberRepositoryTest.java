package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Ryan");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("AA");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("BB");
        repository.save(member1);

        Member result = repository.findByName("AA").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("AA");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("BB");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("CC");
        repository.save(member3);

        // command + option + V
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(3);

    }
}
