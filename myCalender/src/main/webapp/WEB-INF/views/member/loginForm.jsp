<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function goMain(){
		window.location.href = "/main/main.do"
	}
</script>
<title>로그인 폼</title>
</head>
<body>
<div class="container">
	<h3>Login</h3>
	<c:if test="${not empty errorMessage}">
	    <div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<form action="login.do" method="post">
		<div class="form-group">
			<label for="email">ID</label>
			<input type="text" class="form-control" placeholder="ID 입력"
			id="email" name="email" autocomplete="none" required>
		</div>
		<div class="form-group">
			<label for="password">PW</label>
			<input type="password" class="form-control" placeholder="Password 입력"
			id="password" name="password" required>
		</div>
		<button type="submit" class="btn btn-dark">Login</button>
		<button type="button" class="btn btn-dark" onclick="goMain()">Main</button>
	</form>
</div>
</body>
</html>