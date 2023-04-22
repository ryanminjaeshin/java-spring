package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.plaf.metal.MetalMenuBarUI;

// 위 Controller 어노테이션을 보고 스프링이 뜰때 멤머 컨트롤러 객체 생성 => 스프링 컨테이너에서 스피링빈이 관리된다고 말함
// Controller - 외부요청 받고, Service에서 비지니스 로직을 만들고, Repository에서 데이터를 저장
@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService(); 사용하는 대신 @Autowired 사용
     private final MemberService memberService;

    @Autowired
    // 스프링 컨테이너에 MemberService를 연결.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;

    }
}
