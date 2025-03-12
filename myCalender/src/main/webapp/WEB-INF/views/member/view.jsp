<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
<style type="text/css">
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 20px 0;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f4f4f4;
        width: 30%;
    }

    img {
        display: block;
        max-width: 100px;
        height: auto;
    }
</style>
<script type="text/javascript">
$(function(){
}
</script>

</head>
<body>
<div class="container">
	<table>
			<tr>
				<th>사진</th>
				<td>${vo.image }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${vo.email}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${vo.name }</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${vo.nickName }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${vo.gender }</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><fmt:formatDate value="${vo.birth}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${vo.tel }</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${vo.grade }</td>
			</tr>
			<tr>
				<th>지역</th>
				<td>${vo.city }</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td><fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<th>마지막 접속일</th>
				<td><fmt:formatDate value="${vo.last_login}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<th>상태</th>
				<td>${vo.status }</td>
			</tr>
	</table>
</div>
</body>
</html>
