package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring bean 자바코드로 직접 등록 방식
@Configuration
public class SpringConfig {

    //구동시 memberService와 memberRepository 스프링빈에 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // 데이터베이스 변경시, MemoryMemberRepository 명만 변경하면 됨.
        // 구현체 (MemoryMemberRepository) 등록
        return new MemoryMemberRepository();
    }
}
