package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.List;

// 위 Controller 어노테이션을 보고 스프링이 뜰때 멤머 컨트롤러 객체 생성 => 스프링 컨테이너에서 스피링빈이 관리된다고 말함
// Controller - 외부요청 받고, Service에서 비지니스 로직을 만들고, Repository에서 데이터를 저장
@Controller
public class MemberController {
    // private final MemberService memberService = new MemberService(); 사용하는 대신 @Autowired 사용
    private final MemberService memberService;

    @Autowired // 생성자에 Autowired라고 돠어 있으, 컨테이너에 있는 memberService를 연결시켜줌
    // DI *생성자 주입
    // 스프링 컨테이너에 MemberService를 연결.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }
}
