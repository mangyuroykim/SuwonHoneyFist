<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항</title>
		<style>
			table {
				width : 800px;
				border : 1px solid black;
				border-collapse : collapse;
			}
			th {
				background-color : #ccc;
			}
			th,td {
				border : 1px solid black;
			}
		</style>
	</head>
	<body>
		<h1>공지사항 목록</h1>
		<table>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${nList }" var="notice">
				<tr>
					<td>${notice.noticeNo }</td>
					<td><a href="/notice/detail.kh?noticeNo=${notice.noticeNo }">${notice.noticeSubject }</a></td>
					<td>${notice.noticeWriter }</td>
					<td>${notice.regDate }</td>
					<td>${notice.viewCount }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center">
				<c:if test="${currentPage ne 1 }">
					<a href="/notice/list.kh?currentPage=${currentPage - 1 }">이전</a>
				</c:if>
				<c:forEach begin="${ startNavi}" end="${endNavi }" var="i">
					<c:if test="${currentPage eq i }">
						<span style="font-weight:bolder;font-size:30px;">${i }</span>
					</c:if>
				<c:if test="${currentPage ne i }">
				 <a href="/notice/list.kh?currentPage=${i }">${i }</a>
				 </c:if>
				 </c:forEach>
				<c:if test="${currentPage ne naviTotalCount }">
				 <a href="/notice/list.kh?currentPage=${currentPage + 1 }">다음</a>
				 </c:if>
				</td>
			</tr>
		</table>
	</body>
</html>