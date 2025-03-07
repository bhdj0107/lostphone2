package lostphone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/members")
@Transactional
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(
        value = "/members/{id}/login",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Member login(
        @PathVariable(value = "id") Long id,
        @RequestBody LoginCommand loginCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /member/login  called #####");
        Optional<Member> optionalMember = memberRepository.findById(id);

        optionalMember.orElseThrow(() -> new Exception("No Entity Found"));
        Member member = optionalMember.get();
        member.login(loginCommand);

        memberRepository.save(member);
        return member;
    }
}
//>>> Clean Arch / Inbound Adaptor
