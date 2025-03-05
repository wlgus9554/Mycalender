<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Main</title>
</head>
<body>
<div class="container">
	<h2>메인입니다.</h2>		
	
	<c:if test="${not empty msg}">
    	<div class="alert alert-success">${msg}</div>
	</c:if>
	
	<!-- 로그인이 아닌 상태일때 보여줌 -->
	<c:if test="${login == null}">
		<a href="/member/loginForm.do" class="btn btn-dark">로그인</a>
	</c:if>
	
	<!-- 로그인 상태일때 보여줌 -->
	<c:if test="${login != null}">
		<a href="/member/logout.do" class="btn btn-dark">로그아웃</a>
	</c:if>
	
</div>
</body>
</html>