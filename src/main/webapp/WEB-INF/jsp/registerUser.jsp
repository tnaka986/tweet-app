<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきサイト</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="form-wrapper">
	<h1>ユーザ登録</h1>
	<form action="/RegisterUser" method="post">
		<div class="form-item">
			<input type="text" name="userName" required="required" placeholder="ユーザ名"></input>
		</div>
		<div class="form-item">
			<label for="password"></label>
			<input type="password" name="pass" required="required" placeholder="パスワード"></input>
		</div>
		<div class="form-item">
			<label for="password"></label>
			<input type="password" name="passConfrim" required="required" placeholder="パスワード確認"></input>
		</div>
		<div class="button-panel">
			<input type="submit" class="button" title="Resist" value="Resist"></input>
			<br>
		</div>
	</form>
	<div class="error-area">
		<c:if test="${not empty errorMsg}">
			<p><span class="error-msg">
				<c:out value="${errorMsg}"/>
			</span>
		</c:if>
	
	</div>
	<div class="form-footer">
	</div>
</div>
</body>
</html>