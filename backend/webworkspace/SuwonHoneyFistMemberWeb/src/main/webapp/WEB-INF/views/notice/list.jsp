<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록 조회</title>
<style>
	table {
		border: 1px solid black;
		border-collapse: collapse;
		}
	th, td {
		border : 1px solid black;
	}
	</style>
</head>
<body>
	<h1>공지사항</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>		
		</tr>
		<c:forEach items="${nList }" var="notice">
			<tr>
				<td>${notice.noticeNo }</td>
				<td>${notice.noticeSubject }</td>
				<td>${notice.noticeWriter }</td>
				<td>${notice.regDate }</td>
				<td>${notice.viewCount }</td>
			</tr>
			
		</c:forEach>
		<tr>
		 <td colspan="5" align="center">
		 <c:forEach begin="${startNavi }" end="${endNavi }" var="i">
		 <a href="/notice/list.do?currentPage=${i }">${i }</a> 
		 </c:forEach>
		 
<!-- 		 <a href="/notice/list.do?currentPage=2">2</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=3">3</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=4">4</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=5">5</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=6">6</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=7">7</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=8">8</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=9">9</a>  -->
<!-- 		 <a href="/notice/list.do?currentPage=10">10</a>  -->
		 
		 </td>
		</tr>
	</table>
</body>
</html>