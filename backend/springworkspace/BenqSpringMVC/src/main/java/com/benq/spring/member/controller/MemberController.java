package com.benq.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.benq.spring.member.domain.MemberVO;
import com.benq.spring.member.service.MemberService;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService mService;
    
    @RequestMapping(value="/member/register.kh", method=RequestMethod.GET)
    public String showinsertForm(Model model) {
        return "member/insert";
    }
    
    @RequestMapping(value="/member/register.kh", method=RequestMethod.POST)
    public String insertMember(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("memberId") String memberId,
            @RequestParam("memberPw") String memberPw,
            @RequestParam("memberName") String memberName,
            @RequestParam(value="memberAge", required=false, defaultValue="0") int memberAge,
            @RequestParam(value="memberGender", required=false) String memberGender,
            @RequestParam(value="memberEmail", required=false) String memberEmail,
            @RequestParam(value="memberPhone", required=false) String memberPhone,
            @RequestParam(value="memberAddress", required=false) String memberAddress,
            Model model) {
        try {
            MemberVO member = new MemberVO(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddress);
            int result = mService.insertMember(member);
            if(result > 0) {
                // 메인페이지로 이동
                return "redirect:/index.jsp";
            } else {
                // 에러 페이지로 이동
                model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
                return "common/errorPage";
            }
        } catch (Exception e) {
            // 에러 페이지로 이동
            model.addAttribute("msg", e.getMessage());
            return "common/errorPage";
        }
    }
    // 회원정보 수정
    @RequestMapping(value="/member/update.kh", method=RequestMethod.POST)
    public String updateMember(Model model
    		, @RequestParam("memberPw") String memberPw
    		, @RequestParam(value="memberAge", required=false, defaultValue="0") int memberAge
    		, @RequestParam(value="memberGender", required=false) String memberGender
    		, @RequestParam(value="memberEmail", required=false) String memberEmail
    		, @RequestParam(value="memberPhone", required=false) String memberPhone
    		, @RequestParam(value="memberAddress", required=false) String memberAddress
    		, @RequestParam("memberId") String memberId) {
    	try {
    		MemberVO modifyOne = new MemberVO(memberId, memberPw, memberAge, memberGender, memberEmail, memberPhone, memberAddress);
    		int result = mService.updateMember(modifyOne);
    		if(result > 0) {
    			// mypage.jsp로 이동
    			// 서블릿을 이용하여 페이지 이동 vs 바로 jsp로 이동
    			// response.sendRedirect("/member/mypage.kh?memberId="+memberId);
    			// vs request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response)'
    			// return안에 페이지를 적는것이 아니라 redirect를 통해서 requestmapping된 url 호출
    			return "redirect:/member/mypage.kh";
    		}else {
				// errorPage.jsp로 이동
				model.addAttribute("msg", "정보수정이 완료되지 않습니다.");
				return "common/errorPage";
    		}
		} catch (Exception e) {
			e.printStackTrace(); // 콘솔에서 예외 발생 로그를 확인하도록 해줌.
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    	
    }
    //회원정보 수정페이지 바로가기
    @RequestMapping(value="/member/update.kh", method=RequestMethod.GET)
    public String showUpdateForm(Model model
    		, HttpSession session) {
    	try {
			String memberId = (String)session.getAttribute("memberId");
			MemberVO member = mService.selectOneById(memberId);
			if(member != null) {
				model.addAttribute("member",member);
				return "member/update";
			}else {
				// errorPage.jsp로 이동
				model.addAttribute("msg", "정보가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace(); // 콘솔에서 예외 발생 로그를 확인하도록 해줌.
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    }
 // 회원탈퇴
    @RequestMapping(value="/member/delete.kh", method=RequestMethod.GET)
    public String deleteMember(Model model
            , HttpSession session) {
        try {
            String memberId = (String)session.getAttribute("memberId");
            MemberVO member = mService.selectOneById(memberId);
            if(member != null) {
                int result = mService.deleteMember(memberId);
                if(result > 0) {
                    // 성공하면 세션파괴 후 index.jsp로 이동
                	//session.invalidate();
                	//return "redirect:/";
                    return "redirect::/member/logout.kh";
                }else {
                    model.addAttribute("msg", "회원탈퇴가 완료되지 않았습니다.");
                    return "common/errorPage";
                }
            }else {
                model.addAttribute("msg", "회원정보가 존재하지 않습니다.");
                return "common/errorPage";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", e.getMessage());
            return "common/errorPage";
        }
    }
    // 회원 마이페이지 바로가기
    @RequestMapping(value="/member/mypage.kh", method=RequestMethod.GET)
    public String showMypage(Model model
    		, HttpSession session) {
    	try {
    		// 로그인 성공 후 세션에 정보를 저장할 떄 썼던 키값을 전달해줌
			String memberId =(String)session.getAttribute("memberId");
			// mypage.jsp에 뿌려줄 데이터를 비즈니스 로직을 통해서 가져와야 함.
			MemberVO member = mService.selectOneById(memberId);
			if(member != null) {
				//mypage.jsp로 이동
				model.addAttribute("member",member);
				return "member/mypage";
			} else {
				// errorPage.jsp로 이동
				model.addAttribute("msg", "정보가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace(); // 콘솔에서 예외 발생 로그를 확인하도록 해줌.
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    	
    }
    
    @RequestMapping(value="/member/login.kh", method=RequestMethod.POST)
    public String checkLogin(Model model

    		, HttpSession session
    		, @RequestParam("memberId") String memberId
    		, @RequestParam("memberPw") String memberPw) {
    	try {
    		// MemberVO member = new MemberVO(memberId, memberPw);
			MemberVO member = new MemberVO();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member = mService.checkMemberLogin(member);
			if(member != null ) {
				// 로그인 성공 후 세션에 정보 저장
				session.setAttribute("memberId", member.getMemberId());
				session.setAttribute("memberName", member.getMemberName());
				return "redirect:/";
			} else {
				// 로그인 실패
				model.addAttribute("msg", "로그인이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			// 그 외의 예외 발생시(쿼리문 오타, Null PointerException 등...)
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    	
    }
    
    @RequestMapping(value="/member/logout.kh", method=RequestMethod.GET)
    public String memberLogout(Model model, HttpSession session) {
    	try {
			if(session != null) {
				session.invalidate();
				return "redirect:/";
			}else {
				model.addAttribute("msg", "로그아웃을 완료하지 못하였습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    }
}