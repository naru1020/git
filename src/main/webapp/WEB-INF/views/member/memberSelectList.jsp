<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center">
		<div>
			<h3>ȸ�����</h3>
		</div>
		<div>
			<form id="frm" action="" method="post">
				<select id="key" name="key">
					<option value="" selected="selected">�� ü</option>
					<option value="name">�� ��</option>
					<option value="tel">�� ȭ �� ȣ</option>
					<option value="address">�� ��</option>
				</select> <input type="text" id="data" name="data" size="20"
					onkeypress="eventKey(this)">&nbsp;
				<button type="button" onclick="searchData()">�� ��</button>
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="150">�� �� ��</th>
						<th width="150">�� ��</th>
						<th width="150">�� ȭ �� ȣ</th>
						<th width="150">�� ��</th>
						<th width="150">�� ��</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${members }" var="member">
						<tr>
							<td align="center">${member.id }</td>
							<td align="center">${member.name }</td>
							<td align="center">${member.tel }</td>
							<td>&nbsp;${member.address }</td>
							<td align="center">${member.author }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function eventKey(enterKey) {
			if (enterKey == 13) {
				searchData();
			} else {
				return false;
			}
		}

		function searchData() {
			$.ajax({
				url : "ajaxSearchMember.do",
				type : "post",
				data : {
					"key" : $("#key option:selected").val(),
					"data" : $("#data").val()
				},
				dataType : "json",
				success : function(data) {
					if(data.length > 0){
						htmlView(data);
					} else {
						alert("�˻������� �����ϴ� �����Ͱ� �����ϴ�")
						$("#data").val('');
					}
				}
			});
		}
		
		function htmlView(data) {
			$('tbody').remove();
			var tb = $("<tbody />");
			$.each(data, function(index, item){
				var row = $("<td />").append(
				$("<td />").text(item.id),
				$("<td />").text(item.name),
				$("<td />").text(item.tel),
				$("<td />").text(item.address),
				$("<td />").text(item.author)			
				);
				tb.append(row);
			});
			$('table').append(tb);
		}
		
		
		//�ڹٽ�ũ��Ʈ�� �̿��� ajax ȣ��.
		/*function ajaxCall() {
			const ajax = new XMLHttpRequest(); //ajax ��ü ����
			const url = "ajaxSearchMember.do";
			ajax.onload = function(){
				if(ajax.status >= 200 && ajax.status < 300){
					//ajax ȣ�⿡ �������� ��
					successCallFunction(ajax.response)
				} else {
					//�������� ��
					failCallFunction(new Error(ajax.statusText));
				}
			};
			
			ajax.onerror = failCallFunction;
			ajax.open('POST', url);
			ajax.send();
			
		}
		
		function successCallFunction(result){
			console.log(result);
		}
		
		function failCallFunction(error){
			console.log(error);
		}*/
		
	</script>

</body>
</html>