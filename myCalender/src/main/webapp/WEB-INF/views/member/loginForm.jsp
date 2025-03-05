<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>로그인 폼</title>
</head>
<body>
<div class="container">
	<h3>로그인 폼</h3>
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
		<button type="submit" class="btn btn-dark">로그인</button>
	</form>
</div>

</body>
</html>