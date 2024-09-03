package com.benq.boot.notice.model.vo;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data :게터, 세터, toString, equals, hashcode 메소드를 자동 생성
//@AllArgsConstructor : 모든 필드를 매개변수로 가진 매개변수 생성자
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Notice {
	private Integer noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeWriter;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm:ss", timezone="Asia/Seoul")
	private Timestamp noticeDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm:ss", timezone="Asia/Seoul")
	private Timestamp updateDate;
	private Integer viewCount;	
	private Date regDate;
	
	// 파일 정보
	private NoticeFile noticeFile;
	
		
}
