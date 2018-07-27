package hwyoo.sample.spring.controller;

import hwyoo.sample.spring.entity.Member;
import hwyoo.sample.spring.service.MemberService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hanwon.yoo on 2018. 7. 26..
 */

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public NoDataResponse addMember(){
        memberService.addMember();

        NoDataResponse noDataResponse = new NoDataResponse();
        noDataResponse.setSuccess(true);

        return noDataResponse;
    }



    @Data
    class NoDataResponse {
        private boolean isSuccess;
    }
}
