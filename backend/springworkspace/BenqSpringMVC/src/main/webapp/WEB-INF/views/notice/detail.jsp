<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세조회</title>
<link rel="stylesheet" href="../resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h1>공지사항 상세조회</h1>
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
    		<span>${notice.noticeSubject}</span>
    	</li>    	<li>
    		<label>내용</label> 
    		<span>${notice.noticeContent}</span>
    	</li>
    </ul>
    <!-- 댓글 등록 -->
<!--     <form action="/reply/insert.kh" method="post"> -->
    <input type="hidden" name="refNoticeNo" id="refNoticeNo" value="${notice.noticeNo }">
    <table width="500"border="1">
    	<tr>
    		<td>
    			<input type="text" name="replyContent" id="replyContent" size="50">
    		</td>
    		<td>
<!--     			<input type="submit" value ="완료"> -->
				<button id="rSubmit">완료</button>
    		</td>
    	</tr>
    </table>
<!--     </form> -->
    <!-- 댓글 목록 -->
    <table width="550"border="1" id="replyTable">
    	<tbody>
    	</tbody>
    </table>
    <br><br>
    <button type="button" onclick="showUpdateForm();">수정하기</button>
    <button type="button" onclick="noticeDelete();">삭제하기</button>
    <button	type="button" onclick="showNoticeList();">목록으로 이동</button>
    
	<script>
	getReplyList();
	function getReplyList() {
	    var refNoticeNo = "${notice.noticeNo}";
	    $.ajax({
	        url : "/reply/list.kh",
	        data : { "refNoticeNo" : refNoticeNo },
	        type : "GET",
	        success : function(data) {
	            var tableBody = document.querySelector("#replyTable tbody");
	            tableBody.innerHTML = "";
	            var tr, replyWriter, replyContent, rCreateDate, btnArea;
	            if(data.length > 0) {
	                for(var i = 0; i < data.length; i++) {
	                    var replyWriterVal = data[i].replyWriter;
	                    let replyContentVal = data[i].replyContent;
	                    var rCreateDateVal = data[i].rCreateDate;
	                    var replyNoVal = data[i].replyNo;
	                    tr = document.createElement("tr");
	                    replyWriter = document.createElement("td");
	                    replyWriter.textContent = replyWriterVal;
	                    replyContent = document.createElement("td");
	                    replyContent.textContent = replyContentVal;
	                    rCreateDate = document.createElement("td");
	                    rCreateDate.textContent = rCreateDateVal;
	                    
	                    btnArea = document.createElement("td");
	                    var modifyLink = document.createElement("a");
	                    modifyLink.href = "javascript:void(0)";
	                    modifyLink.onclick = function() {	// onclick
	                        showModifyArea(this, replyContentVal, replyNoval);
	                    };
	                    modifyLink.textContent = "수정";
	                    
	                    btnArea.appendChild(modifyLink);
	                    
	                    var deleteLink = document.createElement("a");
	                    deleteLink.href = "javascript:void(0)";
	                    deleteLink.onclick = function() {
	                        deleteReply(replyNoVal);
	                    };
	                    deleteLink.textContent = "삭제";
	                    btnArea.appendChild(deleteLink);
	                    
	                    tr.appendChild(replyWriter);
	                    tr.appendChild(replyContent);
	                    tr.appendChild(rCreateDate);
	                    tr.appendChild(btnArea);
	                    tableBody.appendChild(tr);
	                }
	            }
	        },
	        error : function() {
	            alert("서버 요청 실패!");
	        }
	    });
	}

		function deleteReply(replyNo) {
			$.ajax({
				url : "/reply/remove.kh",
				data : { "replyNo" : replyNo},
				type : "POST",
				success : function(data) {
					if(data == "success") {
						location.href = "/notice/list.kh";
					}else{
						alert("댓글 삭제가 완료되지 않았습니다.");
					}
				},
				error : function() {
					alert("서버 전송 실패!!");
				}
			})
		}
	
	// 댓글 등록
	document.querySelector("#rSubmit").addEventListener("click", function(){
		// $$("#refNoticeNo").val(), $("#replyContent").val()
		var refNoticeNo = document.querySelector("#refNoticeNo").value;
		var replyContent = document.querySelector("#replyContent").value;
		$.ajax({
			url: "/reply/add.kh",
			data : { "refNoticeNo" : refNoticeNo, "replyContent" : replyContent},
			type : "POST",
			success : function(data) {
				if(data == "success") {
					// 리다이렉트를 할 거임.
// 					location.href = "/notice/detail.kh?noticeNo="+refNoticeNo;
					document.querySelector("#replyContent").value = "";
					getReplyList();
				}else{
					alert("댓글 등록이 완료되지 않았습니다.");
				}
		},
		error : function() {
			alert("서버 통신 실패!!");
		}
		});
		
	});
	
	function checkNoticeNo(noticeNo) {
	    if (!noticeNo) {
	        alert("공지사항 번호가 없습니다.");
	        return false;
	    }
	    return true;
	}
		
	
		// 댓글 수정 폼
		function showModifyArea(obj, replyContent, replyNo) {
			var tr = document.createElement("tr");
			var writerTd = document.createElement("td");
			
			var contentTd = document.createElement("td");
			contentTd.colSpan = "3";
			var contentInput = document.createElement("input");
			contentInput.size = "60";
			contentInput.type= "text";
			contentInput.value = replyContent;
			contentTd.appendChild(contentInput);
			tr.appendChild(contentTd);

			var buttonTd = document.createElement("td");
			var button = document.createElement("button");
			button.type="button";
			button.textContent = "수정";
			button.onclick = function() {
				modifyReply(replyNo, this);
			}
			buttonTd.appendChild(button);
			tr.appendChild(buttonTd);
			// 맨마지막에 있어야 되는 코드
// 			document.querySelector("#replyTable tbody")
// 			.appendChild(tr);
			obj.parentElement.paraentElement.after(tr)
		}
		// ajax 댓글 수정
		@ResponseBody
		@RequestMapping("/modify.kh")
		public String modifyReply(ReplyVO reply) {
			int result = rService.updateReply(Reply);
			if(result > 0) {
				return "success";
			}else {
				return "fail";
			}
		}
		// ajax 댓글 삭제
		@ResponseBody
		@RequestMapping("/remove.kh")
		public String removeReply(Integer replyNo) {
			int result = rService.deleteReply(replyNo);
			if(result > 0) {
				return "success";
			}else {
				return "fail";
			}
		}
		//댓글 수정
		function modifyReply(reply, obj) {
			var replyContent = obj.closest("tr").querySelector("input[type=text]").value;
			$.ajax({
				url : "/reply/modify.kh"
				data : { "replyNo" : replyNo, "replyContent" : replyContent },
				type : "POST"
				success : function(data) {
					if(data == "success") {
						getReplyList(); // 댓글 목록 다시 가져오기
					}else {
						alert("댓글 수정이 완료되지 않았습니다.");
					}
				},
				error : functoin() {
					alert("AJAX 통신 실패!");
				}
			})
		}
		// 공지사항 수정하기
	    function showUpdateForm() {
	        location.href="/notice/update.kh?noticeNo=${notice.noticeNo}";
	    }
		// 공지사항 삭제하기
	    function noticeDelete() {
	        if(confirm("삭제하시겠습니까?")) {
	            var inputTag = document.querySelector("#noticeNo");
	            location.href="/notice/delete.kh?noticeNo="+inputTag.value;
	        } else {
	            alert("취소하셨습니다.");
	        }
	    }
	
	    function showNoticeList() {
	        location.href='/notice/list.kh';
	    }
	    
	</script>
</body>
</html>
