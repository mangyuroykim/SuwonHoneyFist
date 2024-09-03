package com.benq.spring.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.benq.spring.notice.domain.NoticeVO;
import com.benq.spring.notice.service.NoticeService;
import com.benq.spring.reply.domain.ReplyVO;
import com.benq.spring.reply.service.ReplyService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nService;
	@Autowired
	private ReplyService rService;
	@RequestMapping(value="/notice/detail.kh", method=RequestMethod.GET)
	public String showNoticeDetail(Model model, @RequestParam(value="noticeNo", required=false) Integer noticeNo) {
	    if (noticeNo == null) {
	        model.addAttribute("msg", "공지사항 번호가 필요합니다.");
	        return "common/errorPage";
	    }

	    System.out.println("Received request for noticeNo: " + noticeNo);
	    
	    NoticeVO notice = nService.selectOneByNo(noticeNo);
	    System.out.println("Retrieved notice: " + notice);
	    
	    if(notice != null) {
	        List<ReplyVO> replyList = rService.selectReplyList(noticeNo);
	        System.out.println("Retrieved reply list: " + replyList);
	        
	        model.addAttribute("rList", replyList);
	        model.addAttribute("notice", notice);
	        return "notice/detail";
	    } else {
	        model.addAttribute("msg", "정보 조회에 실패하였습니다.");
	        return "common/errorPage";
	    }
	}
	
	@RequestMapping(value="/notice/list.kh", method=RequestMethod.GET)
	public String showNoticeList(Model model
			, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		// SELECT * FROM NOTICE_TBL
		try {
//			int currentPage = request.getParameter("currentPage") !=null
//											? Integer.parseInt(request.getParameter("currentPage")) : 1;
			List<NoticeVO> nList = nService.selectNoticeList(currentPage);
			int totalCount = nService.getTotalCount();
			int naviTotalCount = 0;
			int recordCountPerPage = 10;
			if(totalCount % recordCountPerPage > 0) {
				naviTotalCount = totalCount / recordCountPerPage + 1;
			}else {
				naviTotalCount = totalCount / recordCountPerPage;
			}
			// currentPage : 1~10, startNavi : 1, endNavi :10
			// currentPage : 11~20, startNavi : 11, endNavi : 20
			// currentPage : 21~30, startNavi :21, endNavi : 30
			int naviCountPerPage = 10;
			int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
			int endNavi = startNavi + naviCountPerPage -1;
			if(endNavi > naviTotalCount) {
				endNavi = naviTotalCount;
			}
			if(nList.size() > 0) {
				model.addAttribute("startNavi",startNavi);
				model.addAttribute("endNavi",endNavi);
				model.addAttribute("nList",nList);
				return "notice/list";
			}else {
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg","정보가 존재하지 않습니다.");
			return "common/errorPage";
		}
	}
	
    // /notice/register.kh -> register.jsp가 뜨는 핸들러메소드 작성해주세요
    @RequestMapping(value="/notice/register.kh", method=RequestMethod.GET)
    public String showRegisterForm(Model model) {
        return "notice/register";
    }

    @RequestMapping(value="/notice/register.kh", method=RequestMethod.POST)
    public String noticeRegister(Model model
    		, HttpSession session
    		, @RequestParam("noticeSubject") String noticeSubject
    		, @RequestParam("noticeContent") String noticeContent) {
    	try {
        	String noticeWriter = (String)session.getAttribute("memberId");
        	NoticeVO notice = new NoticeVO(noticeSubject, noticeContent, noticeWriter);
        	int result = nService.insertNotice(notice);
        	if(result > 0) {
        		return "redirect:/notice/list.kh";
        	}else {
        		model.addAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
        		return "common/errorPage";
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    }
    @RequestMapping(value="/notice/delete.kh", method=RequestMethod.GET)
    public String deleteNotice(Model model
    		, @RequestParam("noticeNo") Integer noticeNo) {
    	try {
			int result = nService.deleteNotice(noticeNo);
			if(result > 0) {
				//삭제 성공시 리스트로 이동
				return "redirect:/notice/list.kh";
			}else {
				model.addAttribute("msg", "공지사항 삭제가 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    }
    // 공지사항 수정
    @RequestMapping(value="/notice/update.kh", method=RequestMethod.POST)
    public String updateNotice(Model model
    		,@ModelAttribute NoticeVO notice) {
//        	,@RequestParam("noticeNo") int noticeNo
//        	,@RequestParam("noticeSubject") String noticeSubject
//        	,@RequestParam("noticeContent") String noticeContent {
//    	NoticeVO notice = new NoticeVO(noticeNo, noticeSubject, noticeContent);
    	try {
			int result = nService.updateNotice(notice);
			if(result > 0) {
				return "redirect:/notice/detail.kh?noticeNo="+notice.getNoticeNo();
			}else {
				model.addAttribute("msg", "수정이 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
    }
    // 수정페이지로 이동
    @RequestMapping(value="/notice/update.kh", method=RequestMethod.GET)
    public String showUpdateForm(Model model
    		, @RequestParam("noticeNo") Integer noticeNo) {
    	try {
    		// Integer여도 int로 오토언박싱되어 들어감.
			NoticeVO notice = nService.selectOneByNo(noticeNo);
			if(notice != null) {
				model.addAttribute("notice",notice);
				return "notice/update";
			}else {
				model.addAttribute("msg", "존재하지 않는 정보입니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg",e.getMessage());
			return "common/errorPage";
		}
    }
    @RequestMapping(value="/notice/search.kh", method=RequestMethod.POST)
    public String showSearchNotice(Model model
            ,@RequestParam("searchCondition") String searchCondition
            ,@RequestParam("searchKeyword") String searchKeyword) {
    // SearchVO search = new SearchVO(searchCondition, searchKeyword);
    // VO대신 Map을 쓸 수 있음.
    try {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("searchCondition", searchCondition);
        paramMap.put("searchKeyword", searchKeyword);
        List<NoticeVO> searchList = nService.searchNoticesByKeyword(paramMap);
        model.addAttribute("sList", searchList);
        model.addAttribute("searchKeyword", searchKeyword);
        return "notice/search";
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("msg", e.getMessage());
        return "common/errorPage";
    }
}
}