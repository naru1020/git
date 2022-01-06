<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br />
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<c:if test="${id eq null }">
					<li><a href="memberLoginForm.do">Login</a></li>
				</c:if>

				<c:if test="${id ne null }">
					<li><a href="memberLogout.do">LogOut</a></li>
				</c:if>

				<c:if test="${id eq null }">
				<li><a href="memberJoinForm.do">Join</a></li>
				</c:if>
				
				<li><a href="noticeSelectList.do">Notice</a></li>
				<li><a href="#">Product</a></li>
				
				<c:if test="${author eq 'admin' }">
					<li><a href="memberSelectList.do">MemberList</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>