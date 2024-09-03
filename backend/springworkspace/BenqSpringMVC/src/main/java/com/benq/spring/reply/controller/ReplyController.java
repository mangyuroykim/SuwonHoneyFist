package com.benq.spring.reply.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.benq.spring.reply.domain.ReplyVO;
import com.benq.spring.reply.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService rService;
	// --------------------------------------------reply (ajax) --------------------------------------
	
	@ResponseBody
	@RequestMapping(value="/add.kh")
	public String addReply(ReplyVO reply, HttpSession session) {
		String replyWriter = (String)session.getAttribute("memberId");
		reply.setReplyWriter(replyWriter);
		int result = rService.insertReply(reply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("/remove.kh")
	public String removeReply(Integer replyNo) {
		int result = rService.deleteReply(replyNo);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	// ajax 댓글 조회
	@ResponseBody
	@RequestMapping(value="/list.kh", produces="application/json;charset=utf-8")
	public List<ReplyVO> showReplyList(int refNoticeNo) {
	    List<ReplyVO> rList = rService.selectReplyList(refNoticeNo);
	    return rList;
	}
	
//	// ajax 댓글 조회
//	@ResponseBody
//	@RequestMapping("/list.kh")
//	public String showReplyList(int refNoticeNo) {
//		List<ReplyVO> rList = rService.selectReplyList(refNoticeNo);
//		// listToJSONArray
//		JSONArray jsonArr = new JSONArray();
//		for(ReplyVO reply : rList)	{
//			// replyToJSON
//			JSONObject json = new JSONObject();
//			json.put("replyNo", reply.getReplyNo());
//			json.put("replyNoticeNo", reply.getRefNoticeNo());
//			json.put("replyContent", reply.getReplyContent());
//			json.put("replyWriter", reply.getReplyWriter());
//			// TimeStamp는 JSON-SIMPLE 라이브러리가 처리하지 못함.
//			// 수동으로 변환 timeStampToString
//			// 1. SimpleDateFormat을 이용하여 String으로 변환
//			// 2. 쿼리문에서 TO_CHAR() 함수를 이용하여 String으로 변환
//			json.put("rCreateDate", reply.getrCreateDate());
//			json.put("rUpdateDate", reply.getrUpdateDate());
//			json.put("rStatus", reply.getrStatus());
//			jsonArr.add(json);
//		}
//		return jsonArr.toJSONString();
////		Gson gson = new Gson();
////		return gson.toJson(rList);
//	}
	
	
	@RequestMapping(value="/insert.kh", method=RequestMethod.POST)
	public String insertReply(ReplyVO reply, Model model) {
		int result = rService.insertReply(reply);
		return "redirect:/notice/detail.kh?noticeNo=" + reply.getRefNoticeNo();
	}

	@RequestMapping(value="/update.kh", method=RequestMethod.POST)
	public String updateReply(ReplyVO reply, Model model) {
			int result = rService.updateReply(reply);
			return "redirect:/notice/detail.kh?noticeNo="+reply.getRefNoticeNo();
	}
	
	
	@RequestMapping(value="/delete.kh", method=RequestMethod.GET)
	public String deleteReply(Integer replyNo) {
		int result = rService.deleteReply(replyNo);
		return "redirect:/notice/list.kh";
		
	}
}
