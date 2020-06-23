<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきサイト</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<div class="header">
		<div class="header-title">TOP</div>
		<div class="header-middle">
			<form>
				<input type="text" required="required" placeholder="キーワード" name="find">
				<input class="find-button" type="submit" value="検索">
			</form>
		</div>			
		<div class="header-right">
			<ul>
				<li><span style="font-weight:bold;"><c:out value="${loginUser.userName}"/></span>さんログイン中</li>
				<li><a href="/Logout">サインインアウト</a></li>
			</ul>
		</div>
	</div>
	<div class="main">
		<div class="msg-form">
			<c:if test="${not empty errorMsg}">
				<p><span class="error-msg">
					<c:out value="${errorMsg}"/>
				</span></p>
			</c:if>
			<form action="" method="post">
				<textarea type="text" name="inputMutter" required="required" placeholder="いまどうしてる？"></textarea><br>
				<input class="post-button" type="submit" value="投稿する">
			</form>		
		</div>
		<div class="msg-area">
			<c:forEach var="mutter" items="${mutterList}">
				<div class="msg">
					<p><span style="font-weight:bold;">
						<c:out value="${mutter.user.userName}"/>
					</span>
					<span style="padding-left:10px;"> 
					[<c:out value="${mutter.postDate}"/>]
					</span></p>
					<p><c:out value="${mutter.content}"/>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>