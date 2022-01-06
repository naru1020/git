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
		<div>
			<h3>회원가입</h3>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">*아이디</th>
							<td width="250"><input type="email" id="id" name="id"
								required="required">
								<button type="button" id="idCheck" value="No"
									onclick="isIdCheck()">중복체크</button>
						</tr>
						<tr>
							<th width="150">*비밀번호</th>
							<td width="250"><input type="password" id="password"
								name="password" required="required"
								placeholder="enter password..."></td>
						</tr>
						<tr>
							<th width="150">*이름</th>
							<td width="250"><input type="text" id="name" name="name"
								required="required"></td>
						</tr>
						<tr>
							<th width="150">전화번호</th>
							<td width="250"><input type="text" id="tel" name="tel">
						</tr>
						<tr>
							<th width="150">주소</th>
							<td width="250"><input type="text" id="address"
								name="address">
						</tr>
						<tr>
							<th width="150">사진</th>
							<td><input type="file" id="picture" name="picture">
							</td>
						</tr>
					</table>
				</div>

				<div>
					<input type="submit" value="가입"> <input type="reset"
						value="리셋">
				</div>
			</form>
		</div>
	</div>
	<script>
	function isIdCheck(){
		$.ajax({
			url : "isIdCheck.do",
			type : "post",
			data : { "id" : id},
			dataType : "text",
			success : function(data){
				var b = (str ==='true');
				if(b == false){
					alert('이미 존재하는 아이디입니다.');
				} else {
					alert('사용가능한 아이디입니다.');
					$('#idCheck').val('Yes');
					$('#idCheck').hide();
					$('#password').focus();
				}
			},
			error : function(){
				alert('오류가 발생했습니다');
			}
		});
	}

</script>

</body>

</html>