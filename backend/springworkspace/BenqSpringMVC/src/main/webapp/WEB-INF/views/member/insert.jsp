<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
<!-- 		127.0.0.1:8888/member -->
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
		<h1>회원 가입 폼</h1>
		<form action="/member/register.kh" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<ul>
					<li>
						<label>아이디 *</label>
						<input type="text" name="memberId">
					</li>
					<li>
						<label>비밀번호 *</label>
						<input type="password" name="memberPw">
					</li>
					<li>
						<label>이름 *</label>
						<input type="text" name="memberName">
					</li>
					<li>
						<label>나이</label>
						<input type="text" name="memberAge">
					</li>
					<li>
						<label>성별</label>
						남 <input type="radio" name="memberGender" value="M">
						여 <input type="radio" name="memberGender" value="F">
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="memberEmail">
					</li>
					<li>
						<label>전화번호</label>
						<input type="text" name="memberPhone">
					</li>
					<li>
						<label>주소</label>
						<input type="text" id="memberAddress" name="memberAddresss"><button type="button" onclick="searchAddress();">검색</button>
					</li>
				</ul>
			</fieldset>
			<div class="login-area">
				<input type="submit" value="회원가입">
			</div>
		</form>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
		function searchAddress() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		        	document.querySelector("#memberAddress").value = data.address;
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		        }
		    }).open();
		}

		</script>
	</body>
</html>
























