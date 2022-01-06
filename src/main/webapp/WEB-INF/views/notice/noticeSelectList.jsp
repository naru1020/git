<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>�������� ���</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="70">����</th>
						<th width="130">�ۼ���</th>
						<th width="250">����</th>
						<th width="100">�ۼ�����</th>
						<th width="70">��ȸ��</th>
						<th width="100">÷������</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${notices[0].id eq null }">
						<tr>
							<td colspan="6" align="center">�����Ͱ� �������� �ʽ��ϴ�.</td>
						</tr>
					</c:if>
					<c:if test="${notices ne null }">
						<c:forEach items="${notices }" var="notice">
							<tr>
								<td align="center">${notice.id }</td>
								<td align="center">${notice.writeName }</td>
								<td>${notice.title }</td>
								<td align="center">${notice.writeDate }</td>
								<td align="center">${notice.hit }</td>
								<c:if test="${notice.attache ne null }">
									<td align="center"><img src="resources/img/file.png"></td>
								</c:if>
								<c:if test="${notice.attche ne null }">
									<td>align="center>${notice.attache }</td>
								</c:if>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		<c:if test="${id ne null }">
			<button type="submit" value="�۾���"></button>
		</c:if>
	</div>

</body>
</html>