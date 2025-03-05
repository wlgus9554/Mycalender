<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<div class="container">
	<h2>메인입니다.</h2>		
	
	<c:if test="${not empty msg}">
    	<div class="alert alert-success">${msg}</div>
	</c:if>
	
	<c:if test="${login == null}">
		<a href="/member/loginForm.do">로그인</a>
	</c:if>
	
</div>
</body>
</html>