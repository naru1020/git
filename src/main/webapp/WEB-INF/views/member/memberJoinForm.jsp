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
			<h3>ȸ������</h3>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">*���̵�</th>
							<td width="250"><input type="email" id="id" name="id"
								required="required">
								<button type="button" id="idCheck" value="No"
									onclick="isIdCheck()">�ߺ�üũ</button>
						</tr>
						<tr>
							<th width="150">*��й�ȣ</th>
							<td width="250"><input type="password" id="password"
								name="password" required="required"
								placeholder="enter password..."></td>
						</tr>
						<tr>
							<th width="150">*�̸�</th>
							<td width="250"><input type="text" id="name" name="name"
								required="required"></td>
						</tr>
						<tr>
							<th width="150">��ȭ��ȣ</th>
							<td width="250"><input type="text" id="tel" name="tel">
						</tr>
						<tr>
							<th width="150">�ּ�</th>
							<td width="250"><input type="text" id="address"
								name="address">
						</tr>
						<tr>
							<th width="150">����</th>
							<td><input type="file" id="picture" name="picture">
							</td>
						</tr>
					</table>
				</div>

				<div>
					<input type="submit" value="����"> <input type="reset"
						value="����">
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
					alert('�̹� �����ϴ� ���̵��Դϴ�.');
				} else {
					alert('��밡���� ���̵��Դϴ�.');
					$('#idCheck').val('Yes');
					$('#idCheck').hide();
					$('#password').focus();
				}
			},
			error : function(){
				alert('������ �߻��߽��ϴ�');
			}
		});
	}

</script>

</body>

</html>