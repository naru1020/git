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
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="70">순번</th>
						<th width="130">작성자</th>
						<th width="250">제목</th>
						<th width="100">작성일자</th>
						<th width="70">조회수</th>
						<th width="100">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${notices[0].id eq null }">
						<tr>
							<td colspan="6" align="center">데이터가 존재하지 않습니다.</td>
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
			<button type="submit" value="글쓰기"></button>
		</c:if>
	</div>

</body>
</html>