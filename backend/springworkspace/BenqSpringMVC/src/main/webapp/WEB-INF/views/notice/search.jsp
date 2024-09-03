<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 목록 조회</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>공지사항 목록 조회</h1>
		<table>
			<tr>
			<c:choose>>
			<c:when test="${fn:length(sList) == 0 }">
				<tr>
					<td colspan="5">데이터가 존재하지 않습니다 </td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${sList }" var="notice">
				<tr>
					<td>${notice.noticeNo }</td>
					<td><a href="/notice/detail.kh?noticeNo=${notice.noticeNo}">${notice.noticeSubject }</a></td>
					<td>${notice.noticeWriter }</td>
					<td>${notice.noticeDate }</td>
					<td>${notice.viewCount }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>	
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
			</tr>
				<c:forEach items="${sList }" var="notice">
		<tr>
			<td>${notice.noticeNo }</td>
			<td><a href="/notice/detail.kh?noticeNo=${notice.noticeNo}">${notice.noticeSubject }</a></td>
			<td>${notice.noticeWriter }</td>
			<td>${notice.noticeDate }</td>
			<td>${notice.viewCount }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<c:if test="${startNavi ne 1 }">
			<a href="/notice/list.kh?currentPage=${currentPage - 1 }">이전 </a>
			</c:if>
				<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
				<c:if test="${currentPage eq p }">
					<span style ="font-weight:bolder;font-size:30px">%{p }</span>
				</c:if>
				<c:if test="${currentPage ne p }">
				<a href="/notice/list.kh?currentPage=${p }">${p }</a>
				</c:if>
				</c:forEach>
				<c:if test="${endNavi ne naviTotalCount }">
					<a href="/notice/list.kh?currentPage =${currentPage + 1 }">다음</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<form action="/notice/search.kh" method="post"></form>
			<select name ="searchCondition">
				<option value="all">전체</option>
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content" selected>내용</option>
			 </select>
			 <input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
			 <input type="submit" value ="검색">
			</td>
			<td>
				<button type="button">글쓰기</button>
			</td>
		</tr>
		</table>
	</body>
</html>