package com.benq.aop.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benq.aop.member.domain.MemberVO;
import com.benq.aop.member.service.MemberService;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberService mService;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String checkLogin(MemberVO member, HttpSession session) {
        MemberVO loginMember = mService.checkLogin(member);
        if(loginMember != null) {
            session.setAttribute("memberId", loginMember.getMemberId());
            session.setAttribute("memberName", loginMember.getMemberName());
            return "redirect:/index.jsp";
        } else {
            return "redirect:/loginForm.jsp"; // 로그인 실패 시 로그인 폼으로 리다이렉트
        }
    }

    @RequestMapping("/logout")
    public String checkLogout(HttpSession session) {
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/index.jsp";
    }

    // 추가적인 회원 관련 메서드들을 여기에 구현할 수 있습니다.
    // 예: 회원가입, 회원정보 수정 등
}