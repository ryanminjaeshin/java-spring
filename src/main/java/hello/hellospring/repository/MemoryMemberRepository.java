package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// implements MemberRepository -> Option + Enter => Imports methods
public class MemoryMemberRepository implements MemberRepository {

    // Create a map to save member
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // As the new member gets saved, increment the ID
        member.setId(++sequence);
        // Save member Id and member name
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // Consider store.get(id) could be null, Optional.ofNullable is used.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // Map을 Array로 변환하여 리턴.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
