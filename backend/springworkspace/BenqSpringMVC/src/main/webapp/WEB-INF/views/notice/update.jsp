<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
    <h1>공지사항 수정페이지</h1>
    <form action="/notice/update.kh" method="post">
    <ul>
    	<li>
    		<label>번호</label> 
    		<span>${notice.noticeNo}</span>
    		<input type = "hidden" id ="noticeNo" value="${notice.noticeNo}">
    	</li>
    	<li>
    		<label>작성일자</label> 
    		<span>${notice.noticeDate}</span>
    	</li>    	<li>
    		<label>제목</label> 
    		<input type="text" name= "noticeSubject" value="${notice.noticeSubject }">
    		<span>${notice.noticeSubject}</span>
    	</li>    	<li>
    		<label>내용</label>
    		<textarea rows="5" cols="40"name="noticeContent">${notice.noticeContent }</textarea> 
    		<span>${notice.noticeContent}</span>
    	</li>
    </ul>
    <div>
    	<input type="submit" value="수정하기">
    </div>
        </form>
</body>
</html>
