package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//서비스 클래스는 비지니스 용어를 사용해야 기획자와 개발자 소통 원활.
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 가입 X
        // command + option + t => Extract method
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
        // 중복회원 검증 후 통과하면 저장.
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
