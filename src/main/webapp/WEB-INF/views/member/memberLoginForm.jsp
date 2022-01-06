<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<div><h3>로그인</h3></div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="250">
							<input type="email" id="id" name="id" required="required" placeholder="enter Email...">
						</td>
					</tr>
					
					<tr>
						<th width="150">비밀번호</th>
						<td width="250">
							<input type="password" id="password" name="password" required="required" placeholder="enter password...">
						</td>
					</tr>
				</table>
			</div>
			<br>
			
			<div>
				<input type="submit" value="가입">
				<input type="reset" value="리셋">
			</div>
		</form>
	</div>
</div>

</body>
</html>