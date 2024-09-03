<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ajax 개요</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	</head>
	<body>
		<p style="font-size:25px;">
			Ajax는 Asynchronous Javascript And XML이란 용어로<br>
			서버로부터 데이터를 가져와 전체 페이지를 새로 고치지 않고 일부만 로드할 수 있도록 비동기식 요청을 함.
		</p>
		<h3>동기식/비동기식이란?</h3>
		<p>
			동기식은 서버와 클라이언트가 동시에 통신하여 프로세스를 수행 및 종료까지 같이하는 방식 <br>
			이에 반해 비동기식은 페이지 리로딩없이 서버요청 사이사이 추가적인 요청과 처리 가능
		</p>
		<h3>Ajax 구현(Javascript)</h3>
		<h4>1. ajax(js)로 서버에 전송값 보내기</h4>
		<p>버튼 클릭시 전송값을 서버에서 출력</p>
		<input type="text" id="msg-1">
		<button type="button" onclick="ajaxJquery();">보내기(js)</button>
		<h4>버튼 클릭시 서버에서 보낸 값 수신</h4>
		<button type="button" onclick="recvMsgJquery();">받기(js)</button>
		<h4>3. 서버로 전송값 보내고 결과 문자열 받아서 처리</h4>
		<p>숫자 2개를 전송하고 더한 값 받기</p>
		<input type="number" id="num-1">
		<input type="number" id="num-2">
		<button type="button" onclick="sendAndRecvJquery();">전송 및 결과 확인</button>
		
		<script>
		
		document.querySelector("#sendAndJsonList").addEventListener("click", function() {
		    var findId = document.querySelector("#find-id").value;
		    $.ajax({
		        url : "/ajax/sendAndJsonList",
		        data : { "userId" : findId },
		        dataType : "json",
		        type : "GET",
		        success : function(data) {
		            //[{"userPw":"pass01","userId":"khuser01"},{"userPw":"pass02","userId":"khuser02"}]
		            // data[0] => {"userPw":"pass01","userId":"khuser01"}
		            // data[1] => {"userPw":"pass02","userId":"khuser02"}
		            // data[2] => {"userPw":"pass03","userId":"khuser03"}
		            // data[3] => {"userPw":"pass04","userId":"khuser04"}
		            // data[4] => {"userPw":"pass05","userId":"khuser05"}
		            for(var i = 0; i < data.length; i++) {
		                document.querySelector("#p5").innerHTML 
		                    += "아이디 : " + data[i].userId 
		                    + ", 비밀번호 : " + data[i].userPw + "<br>";
		            }
		            alert(data);
		        },
		        error : function() {
		            alert("서버 전송 실패");
		        }
		    });
		});
		
		document.querySelector("#sendAndJson").addEventListener("click", function() {
		    var userId = document.querySelector("#user-id").value;
		    $.ajax({
		        url : "/ajax/sendAndJson",
		        data : { "userId" : userId},
		        dataType : "json",
		        type : "GET",
		        success : function(data) {
		            // data -> {"userPw":"pass01","userId":"khuser01"}
		            document.querySelector("#p55").innerHTML += data.userId + "<br>";
		            document.querySelector("#p55").innerHTML += data.userPw + "<br>";
// 		            alert(data);
		        },
		        error : function() {
		            alert("서버 전송 실패");
		        }
		    });
		});
		
			function ajaxJquery() {
				var msg = $("#msg-1").val();
				$.ajax({
					url : "/ajax/javascript",
					data : { "msg" : msg },
					type : "GET",
					success : function() {
						console.log("서버 전송 성공!");
					},
					error : function() {
						console.log("서버 전송 실패!!");
					}
				});
			}
		
		
			function sendAndRecvJquery() {
				var num1 = $("#num-1").val();
				var num2 = $("#num-2").val();
				$.ajax({
					url : "/ajax/sendAndRecv",
					data : {"num1" : num1, "num2" : num2},
					type : "GET",
					succes : function(data) {
						alert("계산 결과 : " + data);
					},
					error : function() {
						alert("서버 전송 실패");
					}
				});
			}
			function recvMsgJquery() {
				$.ajax({
					url : "/ajax/sendMsg",
// 					data : "",
					type : "GET",
					success : function(data) {
							alert(data);
					},
					error : function() {
						alert("통신 오류!");
					}
				});
			}
			
// 			function ajaxJs() {
// 				// 1. XMLHttpRequest 객체 생성
// 				var xhttp = new XMLHttpRequest();
// 				var msg = document.querySelector("#msg-1").value;
// 				// 2. 요청정보 설정
// 				xhttp.open("GET", "/ajax/javascript?msg="+msg, true);
// 				// 3. 데이터 처리에 따른 동작함수 설정
// 				xhttp.onreadystatechange = function() {
// 					if(this.readyState == 4 && this.status == 200) {//통신이 성공하였을때.
// 						console.log("서버 전송 성공");
// 					} else if(this.readyState == 4) {
// 						console.log("서버 전송 실패!!");
// 					}
// 				};
// 				// 4. 전송
// 				xhttp.send();
// 			}
		</script>
	</body>
</html>