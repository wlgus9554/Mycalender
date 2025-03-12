<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
<style type="text/css">
table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
}

th {
    background-color: #f4f4f4;
}

</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $(".trRow").click(function(){
        let email = $(this).data("email"); // <tr data-email>에서 값 가져오기
        if (email) {
            location.href = "view.do?email=" + email + "&${pageObject.pageQuery}";
        }
    });
});
</script>

</head>
<body>
<div class="container">
		<table border="1" width="100%" cellpadding="5" cellspacing="0">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>닉네임</th>
            <th>성별</th>
            <th>생년월일</th>
            <th>등급</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${memberList}" var="vo">
            <tr class="trRow" data-email="${vo.email}">
                <td>${vo.email}</td>
                <td>${vo.name}</td>
                <td>${vo.nickName}</td>
                <td>${vo.gender}</td>
                <td><fmt:formatDate value="${vo.birth}" pattern="yyyy-MM-dd"/></td>
                <td>${vo.grade}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
