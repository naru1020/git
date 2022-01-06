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
			<h3>회원목록</h3>
		</div>
		<div>
			<form id="frm" action="" method="post">
				<select id="key" name="key">
					<option value="" selected="selected">전 체</option>
					<option value="name">이 름</option>
					<option value="tel">전 화 번 호</option>
					<option value="address">주 소</option>
				</select> <input type="text" id="data" name="data" size="20"
					onkeypress="eventKey(this)">&nbsp;
				<button type="button" onclick="searchData()">검 색</button>
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="150">아 이 디</th>
						<th width="150">이 름</th>
						<th width="150">전 화 번 호</th>
						<th width="150">주 소</th>
						<th width="150">권 한</th>
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
						alert("검색조건을 만족하는 데이터가 없습니다")
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
		
		
		//자바스크립트를 이용한 ajax 호출.
		/*function ajaxCall() {
			const ajax = new XMLHttpRequest(); //ajax 객체 생성
			const url = "ajaxSearchMember.do";
			ajax.onload = function(){
				if(ajax.status >= 200 && ajax.status < 300){
					//ajax 호출에 성공했을 때
					successCallFunction(ajax.response)
				} else {
					//실패했을 때
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