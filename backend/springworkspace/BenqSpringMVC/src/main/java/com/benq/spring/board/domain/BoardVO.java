package com.benq.spring.board.domain;

import java.sql.*;
import java.text.SimpleDateFormat;

public class BoardVO {
    private Integer boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String boardFilename;
    private String boardFileRename;
    private String boardFilepath;
    private Long boardFilelength;
    private Integer boardCount;
    private Date bCreateDate;   
    private Timestamp bUpdateDate;
    private String bStatus;
    
    // 기본 생성자
    public BoardVO() {}
    
    // 매개변수가 있는 생성자
    public BoardVO(String boardTitle, String boardContent, String boardWriter) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
    }
    
    public Integer getBoardNo() {
        return boardNo;
    }
    
    public void setBoardNo(Integer boardNo) {
        this.boardNo = boardNo;
    }
    
    public String getBoardTitle() {
        return boardTitle;
    }
    
    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }
    
    public String getBoardContent() {
        return boardContent;
    }
    
    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }
    
    public String getBoardWriter() {
        return boardWriter;
    }
    
    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }
    
    public String getBoardFilename() {
        return boardFilename;
    }
    
    public void setBoardFilename(String boardFilename) {
        this.boardFilename = boardFilename;
    }
    
    public String getBoardFileRename() {
        return boardFileRename;
    }
    
    public void setBoardFileRename(String boardFileRename) {
        this.boardFileRename = boardFileRename;
    }
    
    public String getBoardFilepath() {
        return boardFilepath;
    }
    
    public void setBoardFilepath(String boardFilepath) {
        this.boardFilepath = boardFilepath;
    }
    
    public Long getBoardFilelength() {
        return boardFilelength;
    }
    
    public void setBoardFilelength(Long boardFilelength) {
        this.boardFilelength = boardFilelength;
    }
    
    public Integer getBoardCount() {
        return boardCount;
    }
    
    public void setBoardCount(Integer boardCount) {
        this.boardCount = boardCount;
    }
    
    public Date getbCreateDate() {
        return bCreateDate;
    }
    
    public void setbCreateDate(Date bCreateDate) {
        this.bCreateDate = bCreateDate;
    }
    
    public Timestamp getbUpdateDate() {
        return bUpdateDate;
    }
    
    public void setbUpdateDate(Timestamp bUpdateDate) {
        this.bUpdateDate = bUpdateDate;
    }
    
    public String getbStatus() {
        return bStatus;
    }
    
    public void setbStatus(String bStatus) {
        this.bStatus = bStatus;
    }
    
    // 포맷팅된 생성 날짜를 반환하는 메소드
    public String getFormattedCreateDate() {
        if (bCreateDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(bCreateDate);
        }
        return "";
    }
    
    @Override
    public String toString() {
        return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
                + ", boardWriter=" + boardWriter + ", boardFilename=" + boardFilename + ", boardFileRename="
                + boardFileRename + ", boardFilepath=" + boardFilepath + ", boardFilelength=" + boardFilelength
                + ", boardCount=" + boardCount + ", bCreateDate=" + bCreateDate + ", bUpdateDate=" + bUpdateDate
                + ", bStatus=" + bStatus + "]";
    }
}