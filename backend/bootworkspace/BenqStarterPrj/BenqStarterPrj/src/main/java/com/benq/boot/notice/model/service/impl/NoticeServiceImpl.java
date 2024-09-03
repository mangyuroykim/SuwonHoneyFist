package com.benq.boot.notice.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.benq.boot.common.utility.Util;
import com.benq.boot.notice.model.mapper.NoticeMapper;
import com.benq.boot.notice.model.service.NoticeService;
import com.benq.boot.notice.model.vo.Notice;
import com.benq.boot.notice.model.vo.NoticeFile;

@Service
public class NoticeServiceImpl implements NoticeService {

//	private NoticeDAO nDao;
	private NoticeMapper mapper;
	
	public NoticeServiceImpl() {}
	@Autowired
	public NoticeServiceImpl(NoticeMapper mapper) {
		this.mapper = mapper;
	}
//	@Autowired
//	public NoticeServiceImpl(NoticeDAO nDao) {
//		this.nDao =nDao;
//	}
	@Override
	public Notice selectOne(Integer noticeNo) {
		Notice notice = mapper.selectOne(noticeNo);
		return notice;
	}

	@Override
	public List<Notice> selectList(Integer currentPage, RowBounds rowBounds) {
		List<Notice> nList = mapper.selectList(currentPage, rowBounds);
		return nList;
	}
	


	@Override
	public int getTotalCount() {
		int totalCount = mapper.getTotalCount();
		return totalCount;
	}

	// 공지사항 수정 Service
	@Override 
	public int updateNotice(Notice notice, MultipartFile reloadFile) throws IllegalStateException, IOException { 
		int result = mapper.updateNotice(notice);
		if(reloadFile !=null) {
			String fileName = reloadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath = "/images/notice/";
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setFileName(fileName);
			noticeFile.setFileRename(fileRename);
			noticeFile.setFilePath(filePath);
			// noticeModify.html에서 input[type=hidden]으로 noticeNo값이 있어야함.
			noticeFile.setNoticeNo(notice.getNoticeNo());
			reloadFile.transferTo(new File("C:uploadFile/notice/"+fileRename));

			NoticeFile nFileOne = mapper.selectNoticeFile(notice.getNoticeNo());
			if(nFileOne != null) {
				result = mapper.updateNoticeFile(nFileOne);
			}else {
				result = mapper.insertNoticeFile(noticeFile);
			}
		}
		return result;
	}

	@Override
	public int deleteNotice(Integer noticeNo) {
		int result = mapper. deleteNotice(noticeNo);
		return result;
	}
	
	@Override
	public int insertNotice(Notice inputNotice, MultipartFile uploadFile) throws IllegalStateException, IOException {
		int result = mapper.insertNotice(inputNotice);
		
		//파일 업로드를 구현 하기 위해추가된 부분
		if(uploadFile != null) {
        	String fileName = uploadFile.getOriginalFilename();
            String fileRename = Util.fileRename(fileName);
            // web용 경로
            String filePath = "/images/notice/";
            // 절대경로로 실제 파일 저장, 저장할때는 Rename 파일명으로 저장
            uploadFile.transferTo(new File("c:/uploadFile/notice/"+fileRename));
            NoticeFile noticeFile = new NoticeFile();
            noticeFile.setFileName(fileName);
            noticeFile.setFileRename(fileRename);
            noticeFile.setFilePath(filePath);
            // notice-mapper 에서 selectKey 태그로 noticeNo 값을 받아올 수 있게 했다
            noticeFile.setNoticeNo(inputNotice.getNoticeNo());
            result =mapper.insertNoticeFile(noticeFile);
    	}  	  	
		return result;
	}
//	@Override
//	public int insertNoticeFile(NoticeFile noticeFile) throws IllegalStateException, IOException {
//		MultipartFile uploadFile = noticeFile.getUploadFile();
//		uploadFile.transferTo(new File("C:/uploadFile/notice/"));
//		int result = mapper.insertNoticeFile(noticeFile);
//		return result;
//	}

	
}

