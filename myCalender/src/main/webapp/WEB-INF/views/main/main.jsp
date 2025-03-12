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
	
	<!-- 로그인이 아닌 상태일때 보여지는 로그인 버튼 -->
	<c:if test="${login == null}">
		<a href="/member/loginForm.do" class="btn btn-dark">Login</a>
	</c:if>
	
	<!-- 로그인 상태일때 보여지는 로그아웃 버튼 -->
	<c:if test="${login != null}">
		<a href="/member/logout.do" class="btn btn-dark">Logout</a>
	</c:if>
	
	<!-- 로그인이 아닌 상태일때 보여지는 회원가입 버튼 -->
	<c:if test="${login == null}">
		<a href="/member/joinForm.do" class="btn btn-dark">Join</a>
	</c:if>
	
	<!-- 관리자로 접속하면 보이는 회원리스트 버튼 -->
	<c:if test="${not empty login and login.grade == 'admin'}">
		<a href="/member/memberList.do" class="btn btn-dark">Member List</a>
	</c:if>
	
</div>
</body>
</html>