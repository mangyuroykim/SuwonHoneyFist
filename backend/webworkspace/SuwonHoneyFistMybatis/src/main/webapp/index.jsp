<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MemberWeb Home</title>
</head>
<body>
    <h1>환영합니다 MemberWeb Home입니다~</h1>
    <c:if test="${not empty memberId }">
        ${memberName }님 환영합니다.
        <a href="/member/login.kh">로그아웃</a> <!-- 로그아웃 링크 -->
        <a href="#">마이페이지</a>
    </c:if>
    <c:if test="${empty memberId }">
        <form action="/member/login.kh" method="post">
            <fieldset>
                <legend>로그인</legend>
                ID : <input type="text" name="memberId"> <br> 
                PW : <input type="password" name="memberPw"> <br> 
                <input type="submit" value="로그인">
            </fieldset>
        </form>
        <a href="/member/join.kh">회원가입</a>
    </c:if>
</body>
</html>
