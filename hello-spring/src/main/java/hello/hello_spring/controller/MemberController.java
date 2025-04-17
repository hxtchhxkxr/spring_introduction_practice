package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // MemberController 객체를 생성해 스프링에 넣음
public class MemberController {

    // new로 객체 생성하면 MemberController 아닌 다른 Controller들도 MemberService 가져다가 쓸 수 있게 됨
    // private final MemberService memberService = new MemberService();

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        // MemberService가 순수 java class여서 안됨
        this.memberService = memberService;
    }
    // -> MemberController 생성시 스프링 빈에 등록되어 있는 MeberService 객체 넣어줌 : 의존관계 주입(Dependency Injection)

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        // 가입 끝나면 홈 화면으로 보냄
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
