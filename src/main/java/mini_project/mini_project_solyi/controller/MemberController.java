package mini_project.mini_project_solyi.controller;

import mini_project.mini_project_solyi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링 컨테이너에 등록되어 스프링이 관리함.
public class MemberController {
    private final MemberService memberService;

    @Autowired //service 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
