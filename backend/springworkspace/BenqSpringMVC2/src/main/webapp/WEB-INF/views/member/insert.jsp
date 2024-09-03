<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 폼</h1>
	<form action="" method="post">
   <fieldset>
       <legend>회원가입</legend>
       <ul>
           <li>
               <label>아이디 *</label>
               <input type="text">
           </li>
           <li>
               <label>비밀번호 *</label>
               <input type="password">
           </li>
           <li>
               <label>이름 *</label>
               <input type="text">
           </li>
           <li>
               <label>나이</label>
               <input type="text">
           </li>
           <li>
               <label>성별</label>
               남 <input type="radio" value="M">
               여 <input type="radio" value="F">
           </li>
           <li>
               <label>이메일</label>
               <input type="text">
           </li>
           <li>
               <label>전화번호</label>
               <input type="text">
           </li>
           <li>
               <label>주소</label>
               <input type="text">
           </li>
       </ul>
   </fieldset>
</form>
</body>
</html>