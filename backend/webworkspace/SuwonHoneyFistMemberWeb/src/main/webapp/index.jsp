<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberWeb Home</title>
</head>
<body>
	<h1>환영합니다 Cival22Member Home 입니다.</h1>
	<c:if test="${sessionScope.memberID ne null }">
				${sessionScope.memberName }님 환영합니다.
				<a href="/member/mypage.do?memberID=${memberID }">마이페이지</a>
				<a href="/member/remove.do?memberID=${memberID }">회원탈퇴</a>
<!-- 				<form action="/member/remove.do" method="get"> -->
<%-- 					<input type="hidden" name="memberID" value="${memerID }"> --%>
<!--					<input type="subbit" value="회원탈퇴"> -->
<!--  				</form> -->
				<a href="/member/logout.do">로그아웃</a>
<%-- 	<% if(sessionScope.memberID != null) { %> --%>
	
<%-- 	<% } else {  %> --%>
	</c:if>
	<c:if test="${sessionScope.memberID eq null }">
		<form action="/member/login.kh" method="post">
			<fieldset>
				<legend>로그인</legend>
				ID : <input type="text"		name="memberID"> <br>
				PW : <input type="password"	name="memberPW"> <br>
				<input type="submit" value="로그인" >
			</fieldset>
		</form>
	</c:if>
<%--	<% } %> --%>
</body>
</html>