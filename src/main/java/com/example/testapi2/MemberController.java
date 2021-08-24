package com.example.testapi2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/test/member")
    @ResponseBody
    public String memberAdd(@RequestBody MemberForm memberForm) {

        log.info("memberForm = {}", memberForm.toString());
        Member member = new Member(memberForm.getName(), memberForm.getAge(), memberForm.getPhoneNumber());
        log.info("member = {}", member.toString());

        memberService.join(member);

        return "ok";
    }

    @GetMapping("/test/member")
    @ResponseBody
    public Member findMember(@RequestParam String name) {

        Member defaultMember = new Member("회원이 없습니다.", "등록한 회원을 조회하세요.", "없음");

        log.info("name = {}", name);
        Optional<Member> member = memberService.findMember(name);
        return member.orElse(defaultMember);
    }
}
