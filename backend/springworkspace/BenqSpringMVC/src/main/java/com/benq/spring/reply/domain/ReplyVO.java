package com.benq.spring.reply.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVO {
	private int replyNo;
	private int refNoticeNo;
	private String replyContent;
	private String replyWriter;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Timestamp rCreateDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Timestamp rUpdateDate;
	private String rStatus;
	
	
	
	
	
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", refNoticeNo=" + refNoticeNo + ", replyContent=" + replyContent
				+ ", replyWriter=" + replyWriter + ", rStatus=" + rStatus + ", rCreateDate=" + rCreateDate
				+ ", rUpdateDate=" + rUpdateDate + "]";
	}



	public int getReplyNo() {
		return replyNo;
	}



	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}



	public int getRefNoticeNo() {
		return refNoticeNo;
	}



	public void setRefNoticeNo(int refNoticeNo) {
		this.refNoticeNo = refNoticeNo;
	}



	public String getReplyContent() {
		return replyContent;
	}



	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}



	public String getReplyWriter() {
		return replyWriter;
	}



	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}



	public String getrStatus() {
		return rStatus;
	}



	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}



	public Timestamp getrCreateDate() {
		return rCreateDate;
	}



	public void setrCreateDate(Timestamp rCreateDate) {
		this.rCreateDate = rCreateDate;
	}



	public Timestamp getrUpdateDate() {
		return rUpdateDate;
	}



	public void setrUpdateDate(Timestamp rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}



	public ReplyVO(int replyNo, int refNoticeNo, String replyContent, String replyWriter, String rStatus,
			Timestamp rCreateDate, Timestamp rUpdateDate) {
		super();
		this.replyNo = replyNo;
		this.refNoticeNo = refNoticeNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.rStatus = rStatus;
		this.rCreateDate = rCreateDate;
		this.rUpdateDate = rUpdateDate;
	}
	public ReplyVO() {}
	
	
}
