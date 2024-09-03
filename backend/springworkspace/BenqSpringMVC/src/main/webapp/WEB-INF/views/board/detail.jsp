<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회</title>
</head>
<body>
	<h1>게시글 상세조회</h1>
	 <ul>
    	<li>
    		<label>제목</label> 
    		<span>${board.boardTitle}</span>
 
    	</li>
    	<li>
    		<label>작성자</label> 
    		<span>${board.boardWriter}</span>
    	</li>    	<li>
    		<label>내용</label> 
    		<span>${board.boardContent}</span>
    	</li>    	
    	<li>
    		<label>첨부파일</label> 
    		<a href="../resources/bUploadFiles/${board.boardFileRename}"download>${board.boardFilename}</a>
    	</li>
    </ul>
    <br>
    <div>
    	<button type="button" onclick="showUpdateForm(${board.boardNo});">수정하기</button>
    	<button type="button" onclick="deleteOne(${board.boardNo})">삭제하기</button>
		<button onclick="goList()">목록으로</button>
		<button onclick="goBack()">뒤로가기</button>
    </div>
   <script>
   function showUpdateForm(boardNo) {
	   location.href="/board/update.kh?boardNo="+boardNo;
	   
   }
   function deleteOne(boardNo) {
	   location.href = "/board/delete.kh?boardNo="+boardNo;
   }
   	function goList() {
   		location.href = "/board/list.kh?currentPage=${currentPage}";
   	}
   	function goBack() {
   		history.go(-1);
   	}
   </script>
</body>
</html>