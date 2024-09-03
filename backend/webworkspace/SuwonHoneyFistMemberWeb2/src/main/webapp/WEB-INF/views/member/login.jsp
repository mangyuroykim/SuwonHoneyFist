<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Login Page</h1>
    <form action="${pageContext.request.contextPath}/member/login.kh" method="post">
        <label for="memberId">ID:</label>
        <input type="text" id="memberId" name="memberId" required>
        <br>
        <label for="memberPw">Password:</label>
        <input type="password" id="memberPw" name="memberPw" required>
        <br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
