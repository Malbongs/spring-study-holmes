<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹게시판-글쓰기</title>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>

</head>
<style>
body {
	height: 100vh;
}

/* 명언 */
.famous-saying-box {
	height: 150px;
	background-color: #333b3d;
}
 
</style>
<body>

	<div class="container-fluid famous-saying-box">
		<div class="container p-3">
			<div class="mt-3">
				<h2 style="color: white">이야기를 나눠요</h2>
				<p style="color: white">어려운 내용은 함께 토론해봐요</p>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row pt-5">
<!------- 왼쪽 사이드 메뉴------------------------------------------------------------------------------------------ -->
			<%--aside부분 --%>
                <%@include file="/WEB-INF/common/groupboard_menu.jsp" %>
<!-- -----------메인-------------------------------------------------------------------------------------------- -->
			<div class="main col-lg-9">
				<h1>글쓰기</h1>
		
				<hr align="left" width="150px" style="border: 0.5px solid #c47100" />


				<form
					action="<%=request.getContextPath()%>/group/groupBoardWritePro"
					enctype="multipart/form-data" method="post">
					<br /> <br />
					
					<input type = "hidden" name= "nickname" value='${com.nickname}'>
					<div class="form-group">
						<label>제목</label> 
						<input type="text" class="form-control" name="title" placeholder="제목을 입력해주세요" />
					</div>


					<div class="form-group">
						<label>내용 :</label>
						<textarea class="summernote" name="content" id="content"></textarea>
					</div>
	
					<div class="d-grid gap-2 " style="float: right;">
						<button class="btn btn-dark" type="button" onclick="location.href = '<%=request.getContextPath()%>/group/groupBoardList'">취소</button>
						<button class="btn btn-dark" type="submit">저장</button>
					</div>
				</form>
			</div>
		</div>
	</div>
    <br>

	<script>
		$('.summernote').summernote({
			height : 350,
			lang : "ko-KR",
			callbacks : {   
				onImageUpload : function(files, editor, welEditable) {       
					for (var i = 0; i < files.length; i++) {
						sendFile(files[i], this);
					}
				}
			} 


		});
		
		function sendFile(file, el) {
			var form_data = new FormData();
			form_data.append('file', file);
			$.ajax({  
				data : form_data,
				type : "POST",
				url : '<%=request.getContextPath()%>/group/imageUpload',
				cache : false,
				contentType : false,
				enctype : 'multipart/form-data', 
				processData : false,
				success : function(url) { 
					let res ="<%=request.getContextPath()%>/studyupload/"
					   res += url.trim();
					 console.log(res)
					$(el).summernote('insertImage', res, function($image) {
						$image.css('width', "25%");
					});
				}
			});
		} 


	</script>
	

</body>
</html>