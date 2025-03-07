<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>회원가입</title>
<style type="text/css">
select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}
</style>
<script>
	document.getElementById("region").addEventListener("change", function() {
	    let selectedRegion = this.value;
	    console.log("선택한 지역:", selectedRegion);
	});
</script>


</head>
<body>
	<div class="container">
		<form action="join.do" method="post" enctype="multipart/form-data">
			<div class="card">
				<div class="card-header">
					<h2>회원가입</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<label id="email">아이디</label> <input id="email" name="email"
							type="text" required>
					</div>
					<div class="row">
						<label id="name">이름</label> <input id="name" name="name"
							type="text" required>
					</div>
					<div class="row">
						<label id="password">비밀번호</label> <input id="password"
							name="password" type="password" required>
					</div>
					<div class="row">
						<label id="password2">비밀번호 재입력</label> 
						<input id="password" type="password">
					</div>
					<div class="row">
						<label id="nickName">닉네임</label> <input id="nickName"
							name="nickName" type="text" required>
					</div>
					<div class="row">
						<label for="birth">생년월일</label>
						<input type="date" id="birth" name="birth" class="form-control">
					</div>
					<div class="row">
	    				<label for="male">남자</label>
						<input type="radio" id="male" name="gender" value="남자">
						&emsp;
	    				<label for="female">여자</label>
						<input type="radio" id="female" name="gender" value="여자">
					</div>
					<div class="row">
						<label id="tel">전화번호</label> <input id="tel" name="tel"
							type="text" required>
					</div>
					<div class="row">
					<label for="city">지역 선택:</label> 
						<select id="city"
							name="city" required>
							<option value="">-- 지역 선택 --</option>
							<option value="서울">서울</option>
							<option value="부산">부산</option>
							<option value="인천">인천</option>
							<option value="대구">대구</option>
							<option value="광주">광주</option>
							<option value="대전">대전</option>
							<option value="울산">울산</option>
							<option value="경기도">경기도</option>
							<option value="강원도">강원도</option>
							<option value="충청북도">충청북도</option>
							<option value="충청남도">충청남도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
							<option value="제주">제주도</option>
						</select>
					</div>
					<div class="row">
						<label for="imageFile"> 프로필 사진: </label> <input
								type="file" class="form-control" 
								id="imageFile" name=imageFile>
					</div>
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-warning btnClass"
						id="submitBtn">가입</button>
					<button type="reset" class="btn btn-secondary btnClass">다시작성</button>
					<button type="button" class="btn btn-secondary btnClass cancleBtn">취소</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
