package com.benq.boot.notice.controller;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.benq.boot.notice.model.service.NoticeService;
import com.benq.boot.notice.model.vo.Notice;
import com.benq.boot.notice.model.vo.Pagination;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    
    private NoticeService nService;

    public NoticeController() {}

    @Autowired
    public NoticeController(NoticeService nService) {
        this.nService = nService;
    }

    @GetMapping("/write")
    public String showWriteForm() {
        return "notice/noticeWrite";
    }

    @PostMapping("/write")
    public String noticeWrite(Notice inputNotice
    		,@RequestParam MultipartFile uploadFile)throws IllegalStateException, IOException {
    	inputNotice.setNoticeWriter("admin");
    	int result = nService.insertNotice(inputNotice, uploadFile);  	
        return "redirect:/notice/list";
    }
    
    @GetMapping("/modify/{noticeNo}")
    public String showModifyForm(@PathVariable Integer noticeNo
    		, Model model) {
    	Notice notice = nService.selectOne(noticeNo);
    	model.addAttribute("notice", notice);
//    	model.addAllAttributes("noticeFile", noticeFile);
    	return "notice/noticeModify";
    }
    // 공지사항 수정 Controller
    @PostMapping("/modify")
    public String noticeModify(Notice notice
    		,@RequestParam MultipartFile reloadFile) throws Exception {
    	int result = nService.updateNotice(notice, reloadFile);
    	return "redirect:/notice/list";
    }
    @GetMapping("/list")
    public String showNoticeList(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage,
                                 Model model) {
        int totalCount = nService.getTotalCount();
        Pagination pn = new Pagination(currentPage, totalCount);
        int limit = pn.getBoardLimit();
        int offset = (currentPage-1)*limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Notice> nList = nService.selectList(currentPage, rowBounds);
        model.addAttribute("nList", nList);
        model.addAttribute("pn", pn);
//        model.addAttribute("startNavi", 1);
//        model.addAttribute("endNavi", 10);
        return "notice/noticeList";
    }
    @GetMapping("/detail/{noticeNo}")
    public String showNoticeDetail(@PathVariable Integer noticeNo
    		, Model model) {
    	Notice notice = nService.selectOne(noticeNo);
    	model.addAttribute("notice", notice);
    	return "notice/noticeDetail";
    }
    


   



    @GetMapping("/delete/{noticeNo}")
    public String deleteNotice(@PathVariable Integer noticeNo) {
    	int result = nService.deleteNotice(noticeNo);
    	return "redirect:/notice/list";
    }
    // [{}, {}, {}, {}, ...]
    // @GetMapping("/list/{currentPage}")
    // public List<Notice> showNoticeList(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage) {
    //     List<Notice> nList = nService.selectList(currentPage);
    //     return nList;
    // }
}
