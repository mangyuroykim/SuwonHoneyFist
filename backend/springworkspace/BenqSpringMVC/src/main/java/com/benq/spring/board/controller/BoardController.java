package com.benq.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.benq.spring.board.domain.BoardVO;
import com.benq.spring.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService bService;
    
    @RequestMapping(value="/register.kh", method=RequestMethod.GET)
    public String showRegisterForm() {
        return "board/register";
    }
    
    @RequestMapping(value="/register.kh", method=RequestMethod.POST)
    public String registerOneBoard(Model model, HttpSession session, RedirectAttributes rattr,
            @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
            @ModelAttribute BoardVO board) throws Exception {
        
        System.out.println("Registering board: " + board);  // 로그 추가
        String memberId = (String)session.getAttribute("memberId");
        
        if(uploadFile != null && !uploadFile.isEmpty()) {
            Map<String, Object> fileInfo = saveFile(uploadFile, session);
            String fileName = (String)fileInfo.get("fileName");
            String fileRename = (String)fileInfo.get("fileRename");
            String filePath = (String)fileInfo.get("filePath");
            Long fileLength = (Long)fileInfo.get("fileSize");
            board.setBoardFilename(fileName);
            board.setBoardFileRename(fileRename);
            board.setBoardFilepath(filePath);
            board.setBoardFilelength(fileLength);
        }
        
        memberId = memberId != null ? memberId : "anonymous";
        board.setBoardWriter(memberId);
        
        int result = bService.insertBoard(board);
        if(result > 0) {
            rattr.addFlashAttribute("message", "게시글이 성공적으로 등록되었습니다.");
        } else {
            rattr.addFlashAttribute("message", "게시글 등록에 실패했습니다.");
        }
        return "redirect:/board/list.kh";
    }
    
    private Map<String, Object> saveFile(MultipartFile uploadFile, HttpSession session) throws IllegalStateException, IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        if(uploadFile != null && !uploadFile.isEmpty()) {
            String fileName = uploadFile.getOriginalFilename();
            Long fileSize = uploadFile.getSize();
            
            String savePath = "/resources/bUploadFiles";
            String filePath = session.getServletContext().getRealPath(savePath);
            // A : 1.png, 1.png
            // 올린시각을 기준으로 파일이름을 만들어서 따로 저장
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String resultStr = sdf.format(new Date(System.currentTimeMillis())); // 20240731161611
            String ext = fileName.substring(fileName.lastIndexOf(".")+1);        // png
            String fileRename = resultStr + "." + ext;
            
            String saveFile = filePath + File.separator + fileRename;
            File file = new File(saveFile);
            uploadFile.transferTo(file);
            
            result.put("fileName", fileName);     // 1.png
            result.put("fileRename", fileRename); // 20240731161611.png
            result.put("filePath", savePath);     // /resources/bUploadFiles
            result.put("fileSize", fileSize);     // 442333
        }
        return result;
    }

	@RequestMapping(value="/update.kh", method=RequestMethod.GET)
    public String showUpdateForm(Model model,
    		@RequestParam Integer boardNo) {
            BoardVO board = bService.selectOneByNo(boardNo);
            model.addAttribute("board", board);
            return "board/update";
        }
    


	// 게시글 수정
	@RequestMapping(value="/update.kh", method=RequestMethod.POST)
	public String updateBoard(Model model
	        , @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
	        , HttpSession session
	        , @ModelAttribute BoardVO board) throws IllegalStateException, IOException {
	    Map<String, Object> infoMap = saveFile(reloadFile, session);
	    String fileName = (String)infoMap.get("fileName");
	    String fileRename = (String)infoMap.get("fileRename");
	    String filePath = (String)infoMap.get("filePath");
	    Long	fileLength	=(Long)infoMap.get("fileSize");
	    board.setBoardFilename(fileName);
	    board.setBoardFileRename(fileRename);
	    board.setBoardFilepath(filePath);
	    board.setBoardFilelength(fileLength);
	    int result = bService.updateBoard(board);
	    return "redirect:/board/detail.kh?boardNo="+board.getBoardNo();
	}

    
    @RequestMapping(value="/delete.kh", method=RequestMethod.GET)
    public String deleteBoard(Model model, RedirectAttributes rattr, @RequestParam Integer boardNo) {
        try {
            int result = bService.deleteBoard(boardNo);
            if(result > 0) {
                rattr.addFlashAttribute("message", "게시물이 성공적으로 삭제되었습니다.");
            } else {
                rattr.addFlashAttribute("message", "게시물 삭제에 실패했습니다.");
            }
            return "redirect:/board/list.kh";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", e.getMessage());
            return "common/errorPage";
        }
    }

    @RequestMapping(value="/list.kh", method=RequestMethod.GET)
    public String showBoardList(Model model, @RequestParam(value="currentPage", defaultValue="1") Integer currentPage) {
        try {
            System.out.println("Entering showBoardList method");
            List<BoardVO> bList = bService.selectBoardList(currentPage);
            System.out.println("Board list size: " + bList.size());
            int totalCount = bService.getTotalCount();
            System.out.println("Total count: " + totalCount);
            int recordCountPerPage = 10;
            int naviTotalCount = (totalCount % recordCountPerPage == 0) 
                ? totalCount / recordCountPerPage 
                : totalCount / recordCountPerPage + 1;
            int naviCountPerPage = 10;
            int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
            int endNavi = Math.min(startNavi + naviCountPerPage - 1, naviTotalCount);
            
            model.addAttribute("bList", bList);
            model.addAttribute("startNavi", startNavi);
            model.addAttribute("endNavi", endNavi);
            model.addAttribute("currentPage", currentPage);
            System.out.println("Exiting showBoardList method");
            return "board/list";
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in showBoardList: " + e.getMessage());
            model.addAttribute("msg", "게시판 목록을 불러오는 중 오류가 발생했습니다: " + e.getMessage());
            return "common/errorPage";
        }
    }
    @RequestMapping(value="/detail.kh", method=RequestMethod.GET)
    public String showBoardDetail(Model model, @RequestParam Integer boardNo) {
        try {
            BoardVO board = bService.selectOneByNo(boardNo);
            model.addAttribute("board", board);
            return "board/detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", e.getMessage());
            return "common/errorPage";
        }
    }
    @RequestMapping(value="/search.kh", method=RequestMethod.POST)
    public String showSearchList(Model model
            , @RequestParam Map<String, String> searchMap
            , @RequestParam(value="page", defaultValue="1") Integer currentPage) {
        
        int totalCount = bService.getTotalCount(searchMap);
        int recordCountPerPage = 10;
        int naviCountPerPage = 10;
        
        int naviTotalCount = (int) Math.ceil((double)totalCount / recordCountPerPage);
        
        int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
        int endNavi = Math.min(startNavi + naviCountPerPage - 1, naviTotalCount);
        
        List<BoardVO> searchList = bService.selectSearchList(searchMap, currentPage, recordCountPerPage);
        
        String searchCondition = searchMap.get("searchCondition");
        String searchKeyword = searchMap.get("searchKeyword");
        
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startNavi", startNavi);
        model.addAttribute("endNavi", endNavi);
        model.addAttribute("naviTotalCount", naviTotalCount);
        model.addAttribute("searchCondition", searchCondition);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("sList", searchList);
        
        return "board/search";
    }
}